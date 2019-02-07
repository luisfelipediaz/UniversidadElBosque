// C Program to find n'th fibonacci Number
#include <stdio.h>
#include <math.h>
#include <sys/time.h>

int fib(int n)
{
    double phi = (1 + sqrt(5)) / 2;
    return round(pow(phi, n) / sqrt(5));
}

int main()
{
    struct timeval stop, start;
    gettimeofday(&start, NULL);

    fib(100000);

    gettimeofday(&stop, NULL);
    printf("took %d\n", stop.tv_usec - start.tv_usec);

    return 0;
}
