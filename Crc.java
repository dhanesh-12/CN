import java.io.*;

class Crc {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] data;
        int[] div;
        int[] divisor;
        int[] rem;
        int[] crc;
        int data_bits, divisor_bits, tot_length;

        // Input: Number of data bits
        System.out.println("Enter number of data bits: ");
        data_bits = Integer.parseInt(br.readLine());
        data = new int[data_bits];

        // Input: Data bits
        System.out.println("Enter data bits: ");
        for (int i = 0; i < data_bits; i++) {
            data[i] = Integer.parseInt(br.readLine());
        }

        // Input: Number of bits in divisor
        System.out.println("Enter number of bits in divisor: ");
        divisor_bits = Integer.parseInt(br.readLine());
        divisor = new int[divisor_bits];

        // Input: Divisor bits
        System.out.println("Enter Divisor bits: ");
        for (int i = 0; i < divisor_bits; i++) {
            divisor[i] = Integer.parseInt(br.readLine());
        }

        // Calculate total length
        tot_length = data_bits + divisor_bits - 1;
        div = new int[tot_length];
        rem = new int[tot_length];
        crc = new int[tot_length];

        // Append data bits to dividend
        for (int i = 0; i < data.length; i++) {
            div[i] = data[i];
        }

        // Print dividend after appending 0's
        System.out.print("Dividend (after appending 0's): ");
        for (int i = 0; i < div.length; i++) {
            System.out.print(div[i]);
        }
        System.out.println();

        // Copy dividend to remainder
        for (int j = 0; j < div.length; j++) {
            rem[j] = div[j];
        }

        // Perform CRC division
        for (int i = 0; i < data_bits; i++) {
            if (rem[i] == 1) {
                for (int j = 0; j < divisor_bits; j++) {
                    rem[i + j] = rem[i + j] ^ divisor[j]; // XOR operation
                }
            }
        }

        // Extract CRC bits
        for (int i = 0; i < crc.length; i++) {
            crc[i] = rem[i];
        }

        // Print CRC bits
        System.out.print("CRC bits: ");
        for (int i = data_bits; i < tot_length; i++) {
            System.out.print(crc[i]);
        }
        System.out.println();

        // Transmit data with CRC
        System.out.print("Transmitted Data: ");
        for (int i = 0; i < data_bits; i++) {
            System.out.print(data[i]);
        }
        for (int i = data_bits; i < tot_length; i++) {
            System.out.print(crc[i]);
        }
        System.out.println();
    }
}
