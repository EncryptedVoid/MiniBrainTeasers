#include <stdio.h>
#include <stdlib.h>

typedef struct MemoryBlock
{
    size_t size;
    int is_free;
    struct MemoryBlock *next;
} MemoryBlock;

MemoryBlock *create_memory_pool(size_t size)
{
    MemoryBlock *block = (MemoryBlock *)malloc(sizeof(MemoryBlock) + size);
    block->size = size;
    block->is_free = 1;
    block->next = NULL;
    return block;
}