***********************************************************************************************************************
************************************************** FUNCTION ***********************************************************

//return something, call method = applay()
Function<Integer, Double> func = num -> num * 2.0;

double result = func.apply(5);

--> sout(result) --> 10.0 

***********************************************************************************************************************
************************************************** CONSUMER ***********************************************************

//void, call method = accept()
Consumer<Integer> print = num -> System.out.println(num);

print.accept(10);  

***********************************************************************************************************************
************************************************** SUPPLIER ***********************************************************

//0 arguments, return type T, call method = .get()
Supplier<Integer> supplier = () -> new Random().nextInt(100);

System.out.println(supplier.get());

***********************************************************************************************************************
************************************************** PREDICATE **********************************************************
//return true or false, call method = .test()
Predicate<Integer> predicate = num -> num > 10;

System.out.println(predicate.test(5));  --> //will return TRUE
System.out.println(predicate.test(15)); --> //will return FALSE

System.out.println(predicate.negate().test(5));  --> //will return FALSE
System.out.println(predicate.negate().test(15)); --> //will return TRUE

***********************************************************************************************************************
***********************************************************************************************************************

