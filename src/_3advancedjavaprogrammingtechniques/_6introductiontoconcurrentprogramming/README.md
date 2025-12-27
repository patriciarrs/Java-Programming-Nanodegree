# Sequential vs Concurrent vs Parallel Programs

## Sequential

- Can only work on one task at a time.
- "You start the laundry machine, and then sit and wait for it to finish before starting the next load."

![Sequential Program](sequential.png "Sequential Program")

## Concurrent

- Can have multiple tasks in progress at the same time.
- "You start the laundry machine. While it's running, you go fold some other clean clothes."

![Concurrent Program](concurrent.png "Concurrent Program")

- In the process of working, the program reaches a point where it can't make anymore progress on task 1 (e.g., waiting
  for
  a DB connection, waiting for a large file to be downloaded, ...).
- It pauses task 1 (saves its progress), and sets it aside to finish later;
  while it's waiting, it starts working on task 2.
- Task 1 is being processed concurrently with task 2: both tasks are in progress at the same time, even if the server
  isn't actively working on both of them at the same time.

## Parallel

- Can actively be working on multiple tasks at the same time.
- "You buy another laundry machine, and then you run two loads of laundry at the same time."

![Parallel Program](parallel.png "Parallel Program")

- Parallel programs are concurrent too:
    - At a point in time, tasks 1, 2, and 3, are all being processed concurrently.
    - Tasks 2 and 3 are being processed in parallel.

# Threads

## Requirements for Using Threads

- **Computer** with a multi-thread CPU.
- **Operating system** with the required drivers.

## Common Uses of Threads

- Doing **multiple tasks** (e.g., multiple user requests, at the same time).
- Perform **long-running background** work (e.g., downloading a large file).
  This allows the main thread to continue doing other things while it waits for the background thread to finish.

## Program Memory (Stack and Heap)

- Program memory contains:
    - **Stack** - contains variables and primitive values.
    - **Heap** - contains objects.

![Memory](memory.png "Memory")

- When a program creates new threads, it allocates a separate **stack** for each thread.
- But they all use the same **heap**.

![Multi-thread Memory](multithread_memory.png "Memory")

- 2 threads can have a reference to the *same object*:
    - E.g., 2+ threads accessing shared state (e.g., ArrayList, HashMap, ...).
- If a thread tries to use more **stack** space than is allocated for it, the **stack** will overflow, an exception will
  be thrown, and the thread will stop running.

## Creating and Running Threads

```
Thread thread = new Thread(() -> System.out.print("world!"));

System.out.print("Hello, ");

thread.start();
thread.join();
```

- When calling the Thread constructor, we pass in an implementation of the runnable interface
  (a subclass or a lambda).

![Multi-thread Memory](execution.png "Memory")

1. The **main thread** *creates* a **2nd thread** *without starting* it
2. The **main thread** prints "Hello, " to the terminal.
3. The **main thread** calls the *start* method to start running the **2nd thread**.
4. The **2nd thread** prints "world!" to the terminal.
5. The **main thread** calls the *join* method.
6. This method *waits* for the **2nd thread** to finish and then *destroys* the **2nd thread**.
7. "Hello, world!" has been printed to the terminal.

## Virtual Threads

- A Thread in Java, creates a **virtual thread** that's managed by the JVM.
- With **virtual threads** the program could create 10,000 Threads, even if the computer's CPU only supports 4 threads.
- **Virtual threads** can create the *illusion* of having multiple threads,
  but a program will not be able to achieve parallelism unless the computer the program is running on supports real
  threads managed by the operating system.

# Thread Execution Order

When we have a bunch of threads running at the same time, they execute in seemingly random order
because threads are run by the **operating system's thread scheduler**.

```
Thread thread = new Thread(() -> System.out.print("world!"));
thread.start();

System.out.print("Hello, ");

thread.join();
```

There are 2 possible outcomes:

1. The **1st thread** *starts* the **2nd thread** and then prints "Hello, ".
   Then, the **2nd thread** prints "world!" and *joins* back to the main thread.
2. The **1st thread** *starts* the **2nd thread**, which immediately runs and prints "world!".
   Then the **1st thread** prints "Hello, " and the **2nd thread** is *joined* back to the **main thread**.
   The end result printed to the terminal is backwards now.

![Race condition](race.png "Memory")

A **Race Condition** is a bug that happens when the correctness of a program
depends on a particular execution order of parallel threads.