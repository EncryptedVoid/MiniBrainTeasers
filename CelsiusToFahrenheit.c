#include <stdio.h>

int main() {
    float celsius;
    printf("Enter temperature in Celsius: ");
    scanf("%f", &celsius);
    printf("%.1f°C = %.1f°F\n", celsius, (celsius * 9/5) + 32);
    return 0;
}