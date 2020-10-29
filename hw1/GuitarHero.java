import synthesizer.GuitarString;

/**
 * A client that uses the synthesizer package to replicate a plucked guitar string sound
 */
public class GuitarHero {

    public static void main(String[] args) {

        /* Keys */
        String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";

        /* Create Strings */
        synthesizer.GuitarString[] strings = new synthesizer.GuitarString[37];
        for (int i = 1; i <= 37; i++) {
            strings[i - 1] = new synthesizer.GuitarString(440 * Math.pow(2, (i - 24) / 12.0));
        }

        while (true) {

            /* check if the user has typed a key; if so, process it */
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                if (keyboard.indexOf(key) != -1) {
                    strings[keyboard.indexOf(key)].pluck();
                }
            }

            /* compute the superposition of samples */
            double sample = 0;
            for (GuitarString s : strings) {
                sample += s.sample();
            }

            /* play the sample on standard audio */
            StdAudio.play(sample);

            /* advance the simulation of each guitar string by one step */
            for (GuitarString s : strings) {
                s.tic();
            }
        }
    }
}
