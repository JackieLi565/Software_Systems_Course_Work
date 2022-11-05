package coe318.lab2;


public class ComplexNumber {
    private double re; //real
    private double im; //imaginary 

 
    public ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }

    //get methods
    public double getReal() {
        return re;	
    }

    public double getImaginary() {
        return im;	
    }

    public ComplexNumber negate() {
        double real = re, imaginary = im;
        
        if (re > 0)
            real = -1*getReal();
        if (im > 0)
            imaginary = -1*getImaginary();

        return new ComplexNumber(real, imaginary);
    }

    public ComplexNumber add(ComplexNumber z) {
        double real = re + z.getReal();
        double imaginary = im + z.getImaginary();
        return new ComplexNumber(real, imaginary);	//A stub: to be fixed
    }

    public ComplexNumber subtract(ComplexNumber z) {
        double real = re - z.getReal();
        double imaginary = im - z.getImaginary();
        return new ComplexNumber(real, imaginary);
    }

    public ComplexNumber multiply(ComplexNumber z) {
        double real, imaginary, hold;
        
        hold = re*z.getReal();
        imaginary = re*z.getImaginary() + im*z.getReal();
        real = -1*im*z.getImaginary() + hold;//i^2 = -1 thus add it to the real part
        
        return new ComplexNumber(real , imaginary);
    }

    public ComplexNumber reciprocal() {
        double real = re/(Math.pow(re, 2) + (Math.pow(im, 2)));
        double imaginary = (-1*im)/(Math.pow(re, 2) + (Math.pow(im, 2)));
        
        return new ComplexNumber(real,imaginary);
        
    }

    public ComplexNumber divide(ComplexNumber z) {
        double a = re;
        double b = im;
        double c = z.getReal();
        double d = z.getImaginary();
        
        double real = ((a*c)+(b*d))/(Math.pow(c, 2) + (Math.pow(d, 2)));
        double imaginary = ((b*c) - (a*d))/(Math.pow(c, 2) + (Math.pow(d, 2)));
        
        return new ComplexNumber (real, imaginary);
    }

    /**
     * Returns a String representation of
     * <em>this</em> in the format:
     * <pre>
     *	real +-(optional) i imaginary
     * </pre> If the imaginary part is zero, only the real part is converted to
     * a String. A "+" or "-" is placed between the real and imaginary parts
     * depending on the the sign of the imaginary part.
     * <p>
     * Examples:
     * <pre>
     *	..println(new ComplexNumber(0,0); -> "0.0"
     *	..println(new ComplexNumber(1,1); -> "1.0 + i1.0"
     *	..println(new ComplexNumber(1,-1); -> "1.0 - i1.0"
     * </pre>
     *
     * @return the String representation.
     */
    @Override
    public String toString() {
//DO NOT MODIFY THIS CODE!
        String str = "" + this.getReal();
        if (this.getImaginary() == 0.0) {
            return str;
        }
        if (this.getImaginary() > 0) {
            return str + " + i" + this.getImaginary();
        } else {
            return str + " - i" + -this.getImaginary();
        }
    }
}