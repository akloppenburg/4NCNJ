import java.io.Serializable;
import java.time.LocalDate;

/**
 * Project 4, CS 2334
 * <P>
 * A <code>NewspaperStory</code> is composed of the date the story was
 * published, the name of the newspaper where the story was published, the
 * length the story in words, the broad topic for the story, the specific
 * subject matter of the story, and two lead news makers in the story.
 * </P>
 * <P>
 * Since all of these elements are present in <code>NewsStory</code>,
 * <code>NewspaperStory</code> is created as a subclass of
 * <code>NewsStory</code>. However, <code>NewspaperStory</code> can implement
 * <code>getLengthInWords</code> because we know the inherent length measurement
 * units for newspaper stories (words), whereas different news stories may use
 * different length units.
 * </P>
 * 
 * @author Dean Hougen
 * @author Cavan Gary - 113388151
 * 
 */
public class NewspaperStory extends NewsStory implements Serializable {
	
	

	/**
	 * Generated serial version ID
	 */
	private static final long serialVersionUID = 5596405914047525792L;

	/**
	 * The constructor which takes parameters for all of the fields can simply
	 * pass them to the constructor for <code>NewsStory</code> and let it do the
	 * work.
	 * 
	 * @param date
	 *            The date the story was published as a java.time.LocalDate.
	 * @param sourceName
	 *            The name of the source in which the story was published.
	 * @param length
	 *            The length of the story.
	 * @param topic
	 *            The broad topic of the story.
	 * @param subject
	 *            The specific subject matter of the story.
	 * @param newsMaker1
	 *            The first news maker featured in the story.
	 * @param newsMaker2
	 *            The second news maker featured in the story.
	 *            
	 * @author Dean Hougen
	 * @author Cavan Gary
	 */
	public NewspaperStory(LocalDate date, String source, int length, String topic, String subject,
			NewsMakerModel newsMaker1, NewsMakerModel newsMaker2) {
		super(date, source, length, topic, subject, newsMaker1, newsMaker2);
	}

	/**
	 * Overrides the <code>getLengthInWords</code> method from
	 * <code>NewsStory</code>.
	 * <P>
	 * Because the inherent length measurement units for newspaper stories are
	 * words, we can simply return the value we get from <code>getLength</code>.
	 * </P>
	 * 
	 * @see NewsStory#getLengthInWords()
	 * @author Dean Hougen
	 */
	@Override
	public int getLengthInWords() {
		return this.getLength();
	}
}
