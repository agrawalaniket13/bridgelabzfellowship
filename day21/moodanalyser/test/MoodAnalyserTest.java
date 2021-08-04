package org.example;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyserTest {

    // Returns SAD if message is "I am in sad mood"
    @Test
    public void givenMessage_ToMoodAnalyser_ShouldReturnSad() throws MoodAnalysisException {

        MoodAnalyser moodAnalyser = new MoodAnalyser("I am in sad mood");
        String message;

        try {

            message = moodAnalyser.analyseMood();
            Assert.assertThat(message, CoreMatchers.is("SAD"));

        } catch (MoodAnalysisException e) {

            e.printStackTrace();

        }

    }

    // Returns Happy if message is "I am in any mood"
    @Test
    public void givenMessage_ToMoodAnalyser_ShouldReturnHappy() throws MoodAnalysisException {

        MoodAnalyser moodAnalyser = new MoodAnalyser("I am in any mood");
        String message;

        try {

            message = moodAnalyser.analyseMood();
            Assert.assertThat(message, CoreMatchers.is("HAPPY"));

        } catch (MoodAnalysisException e) {

            e.printStackTrace();

        }
    }

    // Handles Exception when message is null using Customized Exception
    @Test
    public void givenMessageNull_ToMoodAnalyser_ShouldGiveProperException() {

        MoodAnalyser moodAnalyser = new MoodAnalyser(null);

        try {

            moodAnalyser.analyseMood();

        } catch (MoodAnalysisException e) {

            Assert.assertEquals(MoodAnalysisException.TypeOfException.ENTERED_NULL, e.type);

        }

    }

    // Handles Exception when message is empty using customized exception
    @Test
    public void givenMessageEmpty_ToMoodAnalyser_ShouldGiveProperException() {

        MoodAnalyser moodAnalyser = new MoodAnalyser("");

        try {

            moodAnalyser.analyseMood();

        } catch (MoodAnalysisException e) {

            Assert.assertEquals(MoodAnalysisException.TypeOfException.ENTERED_EMPTY,e.type);

        }
    }
}