package com.example.nitaioanmadalintwittertest

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.nitaioanmadalintwittertest.data.models.userdata.TwitterUserObject
import com.example.nitaioanmadalintwittertest.data.repository.TwitterRepository
import com.example.nitaioanmadalintwittertest.data.utils.CallStatus
import com.example.nitaioanmadalintwittertest.data.utils.Resource
import com.example.nitaioanmadalintwittertest.ui.chooseuser.ChooseUserFragmentViewModel
import com.example.nitaioanmadalintwittertest.utils.livedatautils.Event
import com.example.nitaioanmadalintwittertest.utils.testutils.LifeCycleTestOwner
import com.nhaarman.mockitokotlin2.firstValue
import com.nhaarman.mockitokotlin2.lastValue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.amshove.kluent.mock
import org.junit.*
import org.junit.rules.TestRule
import org.junit.rules.TestWatcher
import org.junit.runner.Description
import org.mockito.ArgumentCaptor
import org.mockito.Captor
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations

@ExperimentalCoroutinesApi
class ChooseUserFragmentViewModelTest {

    @get:Rule
    var coroutineTestRule = CoroutineTestRule()

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    private val twitterRepository: TwitterRepository = mock()

    private lateinit var lifeCycleTestOwner: LifeCycleTestOwner
    private lateinit var chooseUserViewModel: ChooseUserFragmentViewModel

    private val twitterObserver: Observer<Event<Resource<TwitterUserObject>>> = mock()

    @Captor
    private lateinit var captor: ArgumentCaptor<Event<Resource<TwitterUserObject>>>

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        lifeCycleTestOwner = LifeCycleTestOwner()
        lifeCycleTestOwner.onCreate()
        chooseUserViewModel = ChooseUserFragmentViewModel(twitterRepository)
        chooseUserViewModel.getTwitterResponse().observe(lifeCycleTestOwner, twitterObserver)
    }

    @After
    fun tearDown() {
        lifeCycleTestOwner.onDestroy()
    }

    @Test
    fun `getUserData when screen_name is not empty then call getUserData from repository and pass SUCCESS status`() {
        coroutineTestRule.testDispatcher.runBlockingTest {
            lifeCycleTestOwner.onResume()
            val screen_name = "screen_name"
            val twitterObject = mock<TwitterUserObject>()
            `when`(twitterRepository.getUserData(screen_name)).thenReturn(twitterObject)
            chooseUserViewModel.getUserData(screen_name)
            verify(twitterObserver).onChanged(captor.capture())
            Assert.assertEquals(
                captor.firstValue.getContentIfNotHandled()?.status,
                CallStatus.LOADING
            )
            verify(twitterObserver, times(2)).onChanged(captor.capture())
            Assert.assertEquals(
                captor.lastValue.getContentIfNotHandled()?.status,
                CallStatus.SUCCESS
            )
            verify(twitterRepository).getUserData(screen_name)
        }
    }

    @Test
    fun `getUserData when screen_name is empty then do not call getUserData from repository and pass ERROR status`() {
        coroutineTestRule.testDispatcher.runBlockingTest {
            lifeCycleTestOwner.onResume()
            val screen_name = ""
            val twitterObject = mock<TwitterUserObject>()
            `when`(twitterRepository.getUserData(screen_name)).thenReturn(twitterObject)
            chooseUserViewModel.getUserData(screen_name)
            verify(twitterObserver).onChanged(captor.capture())
            Assert.assertEquals(
                captor.firstValue.getContentIfNotHandled()?.status,
                CallStatus.ERROR
            )
            verify(twitterRepository, never()).getUserData(screen_name)
        }
    }

    @ExperimentalCoroutinesApi
    class CoroutineTestRule(val testDispatcher: TestCoroutineDispatcher = TestCoroutineDispatcher()) :
        TestWatcher() {

        override fun starting(description: Description?) {
            super.starting(description)
            Dispatchers.setMain(testDispatcher)
        }

        override fun finished(description: Description?) {
            super.finished(description)
            Dispatchers.resetMain()
        }

    }


}