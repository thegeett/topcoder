public class Bitwise {
	public static void main(String[] args) {
		int bitmask = 0x00FF;
		int val = 0x2222;
		// prints "2"
		System.out.println(val & bitmask);
		int g = 20 >> 2;
		System.out.println("20>>2 = " + g);
		System.out.println(Integer.toBinaryString(8));
		System.out.println(Integer.toBinaryString(~8));
		System.out.println(Integer.toBinaryString(-8>>1));
		System.out.println(Integer.toBinaryString(00+1));
		System.out.println(Integer.toBinaryString(3<<1));
		
		System.out.println(Integer.toBinaryString(5^2));
	}
}
