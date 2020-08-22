public class NBody {

    public static double readRadius(String fileName) {
        In in = new In(fileName);
        in.readInt();
        return in.readDouble();
    }

    public static Planet[] readPlanets(String fileName) {
        In in = new In(fileName);
        int num = in.readInt();
        in.readDouble();
        Planet[] planets = new Planet[num];
        for(int i=0; i<num; i++){
            double xxPos = in.readDouble();
            double yyPos = in.readDouble();
            double xxVel = in.readDouble();
            double yyVel = in.readDouble();
            double mass = in.readDouble();
            String img = in.readString();
            planets[i] = new Planet(xxPos, yyPos, xxVel, yyVel, mass, img);
        }
        return planets;
    }
    public static void main(String[] args) {

        //Collecting all needed input
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        Planet[] planets = readPlanets(filename);
        double radius = readRadius(filename);

        //Drawing the background
        String imageToDraw = "images/starfield.jpg";
        StdDraw.setScale(-radius, radius);
        StdDraw.picture(0, 0, imageToDraw);

        //Drawing all of the planets
        for(Planet p : planets) {
            p.draw();
        }

        //Enabling double buffering
        StdDraw.enableDoubleBuffering();

        //Creating animation
        for(double t=0; t<=T; t+=dt){
            double[] xForces = new double[planets.length];
            double[] yForces = new double[planets.length];

            /**
             * Calculating the net x and y forces for
             * each planet and storing in the arrays respectively
             */
            for(int i=0; i<planets.length; i++) {
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
            }

            //Updating each planets
            for(int i=0; i<planets.length; i++) {
                planets[i].update(dt, xForces[i], yForces[i]);
            }

            //Drawing background image
            StdDraw.picture(0, 0, imageToDraw);
            
            //Drawing all planets
            for(Planet p : planets) {
                p.draw();
            }

            //Showing offscreen buffer and setting pause 10 ms
            StdDraw.show();
            StdDraw.pause(10);
        }
        
        //Printing the universe
        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
        StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
            planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
            planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
}
    }
}