#include <vector>
#include <cstdlib>
#include <iostream>
using namespace std;
 
int main(int argc, char *argv[]) {
    int tama;
 
    if (argc < 2) {
    cout << "No se ha especificado número de elementos, por defecto sera " << 100;
    cout << "\n Uso: <ejecutable> <cantidad>" << endl;
        tama = 100;
    } else {
        tama = atoi(argv[1]);
    }

    vector<long> VectorA, VectorB;
    VectorA.resize(tama, 0);
    VectorB.resize(tama, 0);
    for (long i = 0; i < tama; ++i) {
        VectorA[i] = i + 1;
        VectorB[i] = (i + 1)*10;
    }

    long total = 0;
    for (long i = 0; i < tama ; ++i) {
        total += VectorA[i] * VectorB[i];
    }
 
    cout << "Total = " << total << endl;
    return 0;
}
