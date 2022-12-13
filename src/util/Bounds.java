package src.util;

public class Bounds { 
    private int lower; 
    private int upper; 
   
    public Bounds(int lower, int upper) { 
        setBounds(lower, upper);
    }

    public void setBounds(int lower, int upper) 
    { 
        this.lower = lower; 
        this.upper = upper; 
    }

    public void setLower(int lower) { this.lower = lower; }

    public void setUpper(int upper) { this.upper = upper; }

    public int getLower() { return lower; }

    public int getUpper() { return upper; }

    @Override
    public String toString()
    {
        return String.format("[%d, %d]", lower, upper);
    }
  }