package coe318.lab3;
public class Counter {
    
    private int modulus;
    private int digit; //zero
    private Counter left; //d1
    
    public Counter(int modulus, Counter left) {
        this.modulus = modulus;
        this.left = left;
    }

    public int getModulus() {
        return this.modulus;
    }

    public Counter getLeft() {
       return this.left;
    }

    public int getDigit() {
        return this.digit;
    }

    public void setDigit(int digit) {
        this.digit = digit;
    }

    public void increment() {
        this.digit++; //run 4 times
        if(this.digit == this.modulus) {
            this.digit = 0; //resets to zero  
            
            if(this.left != null) {
                this.left.digit++;
            }
        }
    }

    public int getCount() {
        if(this.left != null) //2 digits
            return ((this.modulus * this.left.digit) + this.digit);
        else 
            return this.digit; //for the first 4 digits
  
    }
 
    @Override
    public String toString() {
        //DO NOT MODIFY THIS CODE
        return "" + getCount();
    }

}
