import javax.sound.midi.*;
import static javax.sound.midi.ShortMessage.*;

public class MiniMusicPlayerV1 {

	public static void main (String[] args) {
		try {
			Sequencer player = MidiSystem.getSequencer();
			player.open();

			Sequence seq = new Sequence(Sequence.PPQ, 4);
			Track track =  seq.createTrack();

			for (int i = 5; i < 61; i += 4) {
				track.add(makeMidiEvent(NOTE_ON, 1, i, 100, i));
				track.add(makeMidiEvent(NOTE_OFF, 1, i, 100, i + 2));
			}

			player.setSequence(seq);
			player.setTempoInBPM(220);
			player.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static MidiEvent makeMidiEvent (int cmd, int chnl, int one, int two, int tick) {
		MidiEvent event = null;
		try {
			ShortMessage msg = new ShortMessage();
			msg.setMessage(cmd, chnl, one, two);
			event = new MidiEvent(msg, tick);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return event;
	}

}