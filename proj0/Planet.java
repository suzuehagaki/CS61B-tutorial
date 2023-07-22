public class Planet
{
    private static final double G = 6.67e-11;
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    public Planet(double xP, double yP, double xV,
                double yV, double m, String img)
    {
        this.xxPos = xP;
        this.yyPos = yP;
        this.xxVel = xV;
        this.yyVel = yV;
        this.mass = m;
        this.imgFileName = img;
    }
    public Planet(Planet p)
    {
        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;
    }
    public double calcDistance(Planet x){
        return Math.sqrt(Math.pow(x.xxPos - this.xxPos,2) + Math.pow(x.yyPos - this.yyPos,2));
    }
    public double calcForceExertedBy(Planet x){
        return G * this.mass * x.mass / Math.pow(calcDistance(x),2);
    }
    public double calcForceExertedByX(Planet x){
        return calcForceExertedBy(x) * (x.xxPos - this.xxPos) / calcDistance(x);
    }
    public double calcForceExertedByY(Planet x){
        return calcForceExertedBy(x) * (x.yyPos - this.yyPos) / calcDistance(x);
    }
    public double calcNetForceExertedByX(Planet[] x){
        double force = 0;
        for(int i = 0; i<x.length;i++)
        {
            if(this.equals(x[i]))
                continue;
            force += this.calcForceExertedByX(x[i]);
        }
        return force;
    }
    public double calcNetForceExertedByY(Planet[] x){
        double force = 0;
        for(int i = 0; i<x.length;i++)
        {
            if(this.equals(x[i]))
                continue;
            force += this.calcForceExertedByY(x[i]);
        }
        return force;
    }
    public void update(double dt, double fx, double fy){
        double ax = fx / this.mass;
        double ay = fy / this.mass;
        this.xxVel += ax * dt;
        this.yyVel += ay * dt;
        this.xxPos += this.xxVel * dt;
        this.yyPos += this.yyVel * dt;
    }
    public void draw(){
        StdDraw.picture(this.xxPos, this.yyPos, "images/" + this.imgFileName);
    }
}  