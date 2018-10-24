package com.company;

import java.util.Scanner;

public class MetricConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double chislo = Double.parseDouble(scanner.nextLine());
        String input = scanner.nextLine();
        String output = scanner.nextLine();

        if (input.equals("m")) {
            if (output.equals("mm")) {
                System.out.println(chislo*1000 + " mm");
            } else if (output.equals("cm")) {
                System.out.println(chislo*100 + " cm");
            } else if (output.equals("mi")) {
                System.out.println((chislo*0.000621371192) + " mi");
            } else if (output.equals("in")) {
                System.out.println(chislo*39.3700787 + " in");
            } else if (output.equals("km")) {
                System.out.println(chislo*0.001 + " km");
            } else if (output.equals("ft")) {
                System.out.println(chislo*3.2808399 + " ft");
            } else if (output.equals("yd")) {
                System.out.println(chislo*1.0936133 + " yd");
            }
        }
        if (input.equals("mm")) {
            if (output.equals("m")) {
                System.out.println(chislo/1000 + " m");
            } else if (output.equals("cm")) {
                System.out.println((chislo/1000)*100 + " cm");
            } else if (output.equals("mi")) {
                System.out.println(((chislo/1000)*0.000621371192) + " mi");
            } else if (output.equals("in")) {
                System.out.println((chislo/1000)*39.3700787 + " in");
            } else if (output.equals("km")) {
                System.out.println((chislo/1000)*0.001 + " km");
            } else if (output.equals("ft")) {
                System.out.println((chislo/1000)*3.2808399 + " ft");
            } else if (output.equals("yd")) {
                System.out.println((chislo/1000)*1.0936133 + " yd");
            }
        }
        if (input.equals("cm")) {
            if (output.equals("mm")) {
                System.out.println((chislo/100)*1000 + " mm");
            } else if (output.equals("m")) {
                System.out.println(chislo/100 + " m");
            } else if (output.equals("mi")) {
                System.out.println(((chislo/100)*0.000621371192) + " mi");
            } else if (output.equals("in")) {
                System.out.println((chislo/100)*39.3700787 + " in");
            } else if (output.equals("km")) {
                System.out.println((chislo/100)*0.001 + " km");
            } else if (output.equals("ft")) {
                System.out.println((chislo/100)*3.2808399 + " ft");
            } else if (output.equals("yd")) {
                System.out.println((chislo/100)*1.0936133 + " yd");
            }
        }
        if (input.equals("mi")) {
            if (output.equals("mm")) {
                System.out.println((chislo/0.000621371192)*1000 + " mm");
            } else if (output.equals("cm")) {
                System.out.println((chislo/0.000621371192)*100 + " cm");
            } else if (output.equals("m")) {
                System.out.println((chislo/0.000621371192) + " m");
            } else if (output.equals("in")) {
                System.out.println((chislo/0.000621371192)*39.3700787 + " in");
            } else if (output.equals("km")) {
                System.out.println((chislo/0.000621371192)*0.001 + " km");
            } else if (output.equals("ft")) {
                System.out.println((chislo/0.000621371192)*3.2808399 + " ft");
            } else if (output.equals("yd")) {
                System.out.println((chislo/0.000621371192)*1.0936133 + " yd");
            }
        }
        if (input.equals("in")) {
            if (output.equals("mm")) {
                System.out.println((chislo/39.3700787)*1000 + " mm");
            } else if (output.equals("cm")) {
                System.out.println((chislo/39.3700787)*100 + " cm");
            } else if (output.equals("mi")) {
                System.out.println(((chislo/39.3700787)*0.000621371192) + " mi");
            } else if (output.equals("m")) {
                System.out.println(chislo/39.3700787 + " m");
            } else if (output.equals("km")) {
                System.out.println((chislo/39.3700787)*0.001 + " km");
            } else if (output.equals("ft")) {
                System.out.println((chislo/39.3700787)*3.2808399 + " ft");
            } else if (output.equals("yd")) {
                System.out.println((chislo/39.3700787)*1.0936133 + " yd");
            }
        }
        if (input.equals("km")) {
            if (output.equals("mm")) {
                System.out.println((chislo/0.001)*1000 + " mm");
            } else if (output.equals("cm")) {
                System.out.println((chislo/0.001)*100 + " cm");
            } else if (output.equals("mi")) {
                System.out.println(((chislo/0.001)*0.000621371192) + " mi");
            } else if (output.equals("in")) {
                System.out.println((chislo/0.001)*39.3700787 + " in");
            } else if (output.equals("m")) {
                System.out.println(chislo/0.001 + " m");
            } else if (output.equals("ft")) {
                System.out.println((chislo/0.001)*3.2808399 + " ft");
            } else if (output.equals("yd")) {
                System.out.println((chislo/0.001)*1.0936133 + " yd");
            }
        }
        if (input.equals("ft")) {
            if (output.equals("mm")) {
                System.out.println((chislo/3.2808399)*1000 + " mm");
            } else if (output.equals("cm")) {
                System.out.println((chislo/3.2808399)*100 + " cm");
            } else if (output.equals("mi")) {
                System.out.println(((chislo/3.2808399)*0.000621371192) + " mi");
            } else if (output.equals("in")) {
                System.out.println((chislo/3.2808399)*39.3700787 + " in");
            } else if (output.equals("km")) {
                System.out.println((chislo/3.2808399)*0.001 + " km");
            } else if (output.equals("m")) {
                System.out.println(chislo/3.2808399 + " m");
            } else if (output.equals("yd")) {
                System.out.println((chislo/3.2808399)*1.0936133 + " yd");
            }
        }
        if (input.equals("yd")) {
            if (output.equals("mm")) {
                System.out.println((chislo/1.0936133)*1000 + " mm");
            } else if (output.equals("cm")) {
                System.out.println((chislo/1.0936133)*100 + " cm");
            } else if (output.equals("mi")) {
                System.out.println(((chislo/1.0936133)*0.000621371192) + " mi");
            } else if (output.equals("in")) {
                System.out.println((chislo/1.0936133)*39.3700787 + " in");
            } else if (output.equals("km")) {
                System.out.println((chislo/1.0936133)*0.001 + " km");
            } else if (output.equals("ft")) {
                System.out.println((chislo/1.0936133)*3.2808399 + " ft");
            } else if (output.equals("m")) {
                System.out.println(chislo/1.0936133 + " m");
            }
        }
    }
}

