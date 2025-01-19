#include <stdio.h>
#include <stdlib.h>

void encrypt_file(const char *input_file, const char *output_file, int key)
{
    FILE *in = fopen(input_file, "rb");
    FILE *out = fopen(output_file, "wb");

    if (!in || !out)
    {
        printf("Error opening files\n");
        return;
    }

    int ch;
    while ((ch = fgetc(in)) != EOF)
    {
        fputc(ch ^ key, out); // Simple XOR encryption
    }

    fclose(in);
    fclose(out);
}