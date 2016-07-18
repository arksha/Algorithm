// 65. Valid Number

// Validate if a given string is numeric.

// Some examples:
// "0" => true
// " 0.1 " => true
// "abc" => false
// "1 a" => false
// "2e10" => true

// Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.

// ----------------------------------------------------------------------------------------------------------------
// only consider three conditions: integer, fractual number, exponent number
use 4 flags to mark is has letter e, ".", digit, 

	public class Solution {
    public boolean isNumber(String s) {
		s = s.trim();
		int n = s.length();
		if (n == 0)
			return false;

		boolean hasE, hasFirst, hasDot, hasDigit;
		hasE = hasFirst = hasDot = hasDigit = false;

		char c;
		for (int i = 0; i < n; i++) {
			c = s.charAt(i);
			if (c >= '0' && c <= '9') {
				hasFirst = hasDigit = true;
				continue;
			}
			switch (c) {
			case 'e':
				// already has 'e' or no digit before 'e'
				if (hasE || !hasDigit)
					return false;
				hasE = true;

				// reset for the exponential number
				hasFirst = hasDigit = false;
				hasDot = true; // the exponent must be an integer, hence
								// regard as if a dot exists already. Set
								// hasDot = false extending to accept any
								// (decimal) number as an exponent.
				continue;
			case '+':
			case '-':
				if (hasFirst)
					return false;
				hasFirst = true;
				continue;
			case '.':
				if (hasDot)
					return false;
				hasFirst = hasDot = true;
				continue;
			default:
				return false;
			}
		}
		return hasDigit;
	}
}
