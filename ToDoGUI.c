#include <stdio.h>
#include <string.h>
#include <stdlib.h>

// Structure to represent a task
typedef struct {
    int id;
    char title[50];
    bool marked;
} Task;

// Function to create a new task
Task* create_task(char *title) {
    Task *task = (Task *) malloc(sizeof(Task));
    strcpy(task->title, title);
    task->id = 1;
    return task;
}

// Function to display the to-do list
void display_list(Task *tasks[], int n) {
    printf("To-Do List:\n");
    for (int i = 0; i < n; i++) {
        if (!tasks[i].marked)
            printf("%d. %s\n", tasks[i].id, tasks[i].title);
        else
            printf("X. %s\n", tasks[i].title);
    }
}

// Function to add a new task
void add_task(Task *tasks[], int n, char *title) {
    Task *new_task = create_task(title);
    strcpy(tasks[n], new_task);
    n++;
}

// Function to remove a task by id
int remove_task(int id, Task *tasks[], int n) {
    if (id > 0 && id <= n)
        for (int i = 1; i < n; i++)
            if (tasks[i].id == id)
                tasks[n - 1] = tasks[i];
        return n--;
}

// Function to mark a task as completed
void mark_task(Task *tasks[], int n, bool completed) {
    int index = 0;
    while (index < n) {
        if (!completed && tasks[index].id == 1)
            break;
        index++;
    }
    if (index < n)
        tasks[index].marked = !tasks[index].marked;
}

// Main function
int main() {
    Task *tasks[10];
    int n;

    printf("To-Do List App\n");
    printf("1. Add task\n");
    printf("2. Remove task\n");
    printf("3. Mark as completed\n");
    printf("4. Display list\n");
    printf("5. Quit\n");

    while (1) {
        int choice;
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                printf("Enter title: ");
                char *title = malloc(50);
                gets(title);
                add_task(tasks, n, title);
                break;
            case 2:
                printf("Select task to remove:\n");
                int selected_task;
                for (int i = 0; i < n; i++)
                    printf("%d. %s\n", i + 1, tasks[i].title);
                scanf("%d", &selected_task);
                if (selected_task > 0 && selected_task <= n)
                    remove_task(selected_task - 1, tasks, n);
                break;
            case 3:
                printf("Select task to mark as completed:\n");
                int selected_task = 0;
                for (int i = 0; i < n; i++)
                    if (!tasks[i].marked && i + 1 <= n)
                        selected_task = i + 1;
                if (selected_task > 0 && selected_task <= n) {
                    printf("Mark as completed: %s\n", tasks[selected_task - 1].title);
                    mark_task(tasks, n, true);
                    break;
                }
                else
                    printf("Invalid task selection\n");
                break;
            case 4:
                display_list(tasks, n);
                printf("\n");
                break;
            case 5:
                printf("Goodbye!\n");
                return 0;
            default:
                printf("Invalid choice. Please try again.\n");
        }
    }

    return 0;
}
