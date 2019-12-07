package map.plain.text;

import java.util.List;

import javax.xml.crypto.dsig.TransformService;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.junit.JUnitStory;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.CandidateSteps;
import org.jbehave.core.steps.InstanceStepsFactory;


import map.step.TraderStep;

public class TraderStories extends JUnitStory
{

	@Override
	public Configuration configuration()
	{
		return new MostUsefulConfiguration()
				.useStoryLoader(new LoadFromClasspath(this.getClass()))
				.useStoryReporterBuilder(new StoryReporterBuilder()
				.withDefaultFormats()
				.withFormats(Format.CONSOLE, Format.TXT ,Format.HTML));
	}
	
	public List<CandidateSteps> candidateSteps() 
	{
		return new InstanceStepsFactory(configuration(), new TraderStep(new  TradingService()))
				.createCandidateSteps();
	}

}

	


