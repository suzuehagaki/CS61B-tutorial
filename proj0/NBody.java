public class NBody {
    public static double readRadius(String fileName){
        In in = new In(fileName);
        in.readInt();
        return in.readDouble();
    }
    public static Planet[] readPlanets(String fileName){
        In in = new In(fileName);
        int count = in.readInt();
        in.readDouble();
        Planet[] planets = new Planet[count];
        for(int i = 0; i < count; i++){

            planets[i] = new Planet(in.readDouble(),in.readDouble(),in.readDouble(),in.readDouble(),in.readDouble(),in.readString());
        }
        return planets;
    }

    public static void main(String[] args){
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String fileName = args[2];
        double radius = readRadius(fileName);
        Planet[] planets = readPlanets(fileName);
        StdDraw.setScale(-radius,radius);
        StdDraw.enableDoubleBuffering();
        StdDraw.clear();
        StdDraw.picture(0,0,"./images/starfield.jpg");
        for(int i = 0; i < planets.length; i++){
            planets[i].draw();
        }

        double currentTime = 0;
        double[] xForce = new double[planets.length];
        double[] yForce = new double[planets.length];
        while(currentTime <= T){
            for(int i = 0; i<xForce.length;i++){
                xForce[i] = planets[i].calcNetForceExertedByX(planets);
                yForce[i] = planets[i].calcNetForceExertedByY(planets);
            }
            for(int i = 0; i<planets.length;i++){
                planets[i].update(dt,xForce[i],yForce[i]);
            }
            StdDraw.clear();
            StdDraw.picture(0,0,"./images/starfield.jpg");
            for(int i = 0; i < planets.length; i++){
                planets[i].draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
            currentTime += dt;
        }
        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                        planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                        planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
        }       
    }
}
