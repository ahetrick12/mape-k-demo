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

    public int getLower() { return lower; }

    public int getUpper() { return upper; }
  }