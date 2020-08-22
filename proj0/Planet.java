public class Planet {

    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    private static final double g = 6.67e-11;
    
    public Planet (double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet (Planet p) {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p) {
        double dx = this.xxPos - p.xxPos;
        double dy = this.yyPos - p.yyPos;
        return Math.sqrt(dx*dx + dy*dy); 
    }
    
    public double calcForceExertedBy(Planet p) {
        double r = this.calcDistance(p);
        return g * this.mass * p.mass / (r*r);
    }

    public double calcForceExertedByX (Planet p){
        double f = calcForceExertedBy(p);
        double r = calcDistance(p);
        return f * (p.xxPos - this.xxPos) / r;
    }

    public double calcForceExertedByY (Planet p){
        double f = calcForceExertedBy(p);
        double r = calcDistance(p);
        return f * (p.yyPos - this.yyPos) / r;
    }

    public double calcNetForceExertedByX (Planet[] allPlanets) {
        double fxNet = 0; 
        for(Planet p : allPlanets) {
            if(!this.equals(p)){
                fxNet += this.calcForceExertedByX(p);
            }
        }
        return fxNet;
    }

    public double calcNetForceExertedByY (Planet[] allPlanets) {
        double fyNet = 0; 
        for(Planet p : allPlanets) {
            if(!this.equals(p)){
                fyNet += this.calcForceExertedByY(p);
            }
        }
        return fyNet;
    }

    public void update(double dt, double xf, double yf) {
        double ax = xf/this.mass;
        double ay = yf/this.mass;
        this.xxVel += dt * ax;
        this.yyVel += dt * ay;
        this.xxPos += dt * this.xxVel;
        this.yyPos += dt * this.yyVel;
    }

    //Drawing one planet
    public void draw() {
        String imageToDraw = "images/" + this.imgFileName;
        StdDraw.picture(this.xxPos, this.yyPos, imageToDraw);
    }
}