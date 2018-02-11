def procedureDouble(f: Int => Int): Int => Int = x => f(f(x))

def inc = (x: Int) => x + 1

procedureDouble(inc)(1)

procedureDouble(procedureDouble(procedureDouble(inc)))(5)

//Innermost procedure adds 1 + 1 = 2
//Second procedure doubles that and adds 2 + 2 = 4
//Third procedure doubles that and adds 4 + 4 = 8
//Total increment from 5 = 5 + 8 = 13