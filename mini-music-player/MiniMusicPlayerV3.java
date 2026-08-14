import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;
import java.util.Random;

import static javax.sound.midi.ShortMessage.*;

public class MiniMusicPlayerV3 {

	private MyDrawPanel panel;
	private Random random = new Random();

	public static void main (String[] args) {
		new MiniMusicPlayerV3().go();
	}

	public void go () {
		setUpGui();

		try {
			Sequencer player = MidiSystem.getSequencer();
			player.open();

			Sequence seq = new Sequence(Sequence.PPQ, 4);
			Track track =  seq.createTrack();

			int[] eventsIWant = {127};
			player.addControllerEventListener(panel, eventsIWant);

			for (int i = 5; i < 61; i += 4) {
				track.add(makeMidiEvent(NOTE_ON, 1, i, 100, i));

				track.add(makeMidiEvent(CONTROL_CHANGE, 1, 127, 0, i));

				track.add(makeMidiEvent(NOTE_OFF, 1, i, 100, i + 2));
			}

			player.setSequence(seq);
			player.setTempoInBPM(120);
			player.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setUpGui () {
		JFrame frame = new JFrame("MY First Music Video");
		panel = new MyDrawPanel();
		frame.setContentPane(panel);
		frame.setBounds(30, 30, 300, 300);
		frame.setVisible(true);
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

	class MyDrawPanel extends JPanel implements ControllerEventListener {

		private boolean msg = false;

		public void controlChange (ShortMessage event) {
			msg = true;
			repaint();
		}

		public void paintComponent (Graphics g) {
			if (msg) {
				int r = random.nextInt(250);
				int gr = random.nextInt(250);
				int b = random.nextInt(250);

				g.setColor(new Color(r, gr, b));

				int height = random.nextInt(120) + 10;
				int width = random.nextInt(120) + 10;

				int xPos = random.nextInt(40) + 10;
				int yPos = random.nextInt(40) + 10;

				g.fillRect(xPos, yPos, width, height);
				msg = false;
			}
		}
	}

}