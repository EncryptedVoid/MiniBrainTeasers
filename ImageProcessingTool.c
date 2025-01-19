#include <stdio.h>
#include <stdlib.h>

typedef struct
{
    unsigned char red, green, blue;
} Pixel;

typedef struct
{
    int width, height;
    Pixel *pixels;
} Image;

Image *create_image(int width, int height)
{
    Image *img = (Image *)malloc(sizeof(Image));
    img->width = width;
    img->height = height;
    img->pixels = (Pixel *)malloc(width * height * sizeof(Pixel));
    return img;
}

void grayscale_filter(Image *img)
{
    for (int i = 0; i < img->width * img->height; i++)
    {
        unsigned char gray = (img->pixels[i].red +
                              img->pixels[i].green +
                              img->pixels[i].blue) /
                             3;
        img->pixels[i].red = img->pixels[i].green = img->pixels[i].blue = gray;
    }
}