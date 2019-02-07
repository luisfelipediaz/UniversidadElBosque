#include <stdio.h>
#include <stdlib.h>
#include <sys/time.h>

int main(void)
{
    double x, y, z, cont;
    x = 0;
    y = 1;

    struct timeval stop, start;
    gettimeofday(&start, NULL);

    for (cont = 1; cont < 100000; cont = cont + 1)
    {
        z = x + y;
        x = y;
        y = z;
    }

    gettimeofday(&stop, NULL);
    printf("took %d\n", stop.tv_usec - start.tv_usec);

    return 0;
}
