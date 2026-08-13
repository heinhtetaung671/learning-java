import javax.sound.midi.*;
import static javax.sound.midi.ShortMessage.*;

public class MiniMusicApp {

	public static void main (String[] args) {

		if ( args.length < 2 ) {
			System.out.println("Please provide arguments..! ");
		} else {
			new MiniMusicApp().play( Integer.parseInt(args[0]), Integer.parseInt(args[1]) );
		}
	}

	public void play (int instrument, int note) {
		try {
			Sequencer player = MidiSystem.getSequencer();
			player.open();

			Sequence seq = new Sequence(Sequence.PPQ, 4);

			Track track = seq.createTrack();

			ShortMessage msg = new ShortMessage();
			msg.setMessage(PROGRAM_CHANGE, 1, instrument, 0);
			MidiEvent changeInstrument = new MidiEvent(msg, 1);
			track.add(changeInstrument);

			ShortMessage msg1 = new ShortMessage();
			msg1.setMessage(NOTE_ON, 1, note, 100);
			MidiEvent noteon = new MidiEvent(msg1, 1);
			track.add(noteon);

			ShortMessage msg2 = new ShortMessage();
			msg2.setMessage(NOTE_OFF, 1, note, 100);
			MidiEvent noteoff = new MidiEvent(msg2, 16);
			track.add(noteoff);

			player.setSequence(seq);

			player.start();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}