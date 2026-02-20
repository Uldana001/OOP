public enum Gender {
    BOY, GIRL;  
    
    @Override
    public String toString() {
        if (this == BOY) {
            return "B";
        } else {
            return "G";
        }
    }
}