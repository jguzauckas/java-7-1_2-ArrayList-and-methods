# Introduction to `ArrayList` and `ArrayList` Methods

While arrays have proven to be invaluable, they have had a primary setback that we have had to work around: their immutability. Specifically, the fact that their length is immutable. There have been many problems that could have been made significantly easier if we could have added new spots to, or removed some spots from, an existing array.

This new data structure gives us that flexibility: the `ArrayList`

---

## What is an `ArrayList`?

An `ArrayList` is another built-in data structure in Java that allows us to store multiple values or objects. Like arrays, it uses an index system, starting at `0` to refer to its elements.

There are three significant ways that it does this fundamentally differently than arrays:
- All values in an `ArrayList` are treated as objects, even primitive types. This means that when an `ArrayList` holds primitive data, it utilizes the wrapper classes (`Integer` for `int`, etc., see Unit 2 Section 8).
- New objects can be added, or existing objects can be removed at any time. This means that the size of an `ArrayList` fluctuates as it is being used, something that could never have been true of an array. When new objects are added, or existing objects are removed, the indices of elements can all be shifted. Just because the index `5` refers to one element right now, doesn't mean that it must refer to the same element later, even if that element has never been edited or adjusted by the user.
- Interacting with an `ArrayList` is primarily driven by methods (like any other object), as opposed to certain included functionality of arrays like the square bracket and index notation `[5]`, and the `length` parameter.

This flexibility comes at a cost though: efficiency. The rigidity of arrays made them extremely efficient to work with in various situations. This is always a tradeoff though, as sometimes we would solve problems in an inefficient way because arrays were so rigid. This gives us an opportunity to make some of those situations more efficient, even if `ArrayList` objects themselves aren't more efficient. Ultimately, this means that `ArrayList` objects are not meant to replace arrays, but rather be another tool to approach similar problems!

One odd feature of an `ArrayList`, is that depending on how it is set up by us, it might not be restricted to one type. By default, an `ArrayList` accepts any type to be added, whether it is a primitive type (see reference to Wrapper Classes above) like `int`, `double`, or `boolean`, or an immutable object, like `String`, or a mutable object, like `Person`. This is a cool feature, but is one we rarely use.

The problem is that if an `ArrayList` can hold anything, the computer struggles to predict how everything using that `ArrayList` will work. If we meant to just put `int` and `double` types into an `ArrayList` and were adding things up, the compiler can't guarantee that anything else didn't manage to sneak into the `ArrayList`, and would produce an error later.

Due to this, we also try to **type** our `ArrayList` objects, meaning we assign them a singular type to work with like our arrays, so that the compiler can always ensure that there aren't going to be any unexpected problems around what is in an `ArrayList` when the program runs.

This allows us to catch things at **compile-time** (this is always actively happening while we code, helping with the syntax highlighting and error catching), as opposed to **run-time** (this is when we hit the "run" button). The compiler is not perfect, and can miss certain kinds of issues (like `IndexOutOfBoundsExceptions`), but can help save us a lot of time and energy while we are actively developing a program.

---

## Making `ArrayList` Objects

Despite being a data structure and sharing some things in common with arrays, the use of `ArrayList` objects introduces some different syntax (more than anything else to help differentiate them from arrays).

### `import`

The first difference from arrays, is that we have to include an `import` statement at the top of our Java files to utilize an `ArrayList`. While `ArrayList` is a part of the core of Java, so it is installed when Java is installed, we need to specify to Java that we want to use it in the file.

The `import` statement looks like this:

```java
import java.util.ArrayList;
```

The nice part about this is that this never changes. Want to use an `ArrayList`? Put this exact `import` statement at the top of your file and you are good to go!

It is important to specify that this needs to go at the very top of the Java file, before anything else - even classes!

### Creating an `ArrayList`

Once we have imported `ArrayList`, we are ready to start using them! `ArrayList` are objects, so that means that creating them shares many similarities with creating any other object, even arrays. To create an `ArrayList`, we just use the keyword `new` and the constructor call `ArrayList()`, like this example from the `NotesCreate1.java` file:

```java
new ArrayList();
```

When we constructed arrays, we needed to provide an `int` parameter to denote how many things we wanted to store. Since `ArrayList` objects can grow and shrink, we don't do this, and instead will just add objects later on when needed. This means that by default, an `ArrayList` is empty: it doesn't contain anything!

Creating objects is only useful if they are assigned to variables so they can be used later. With `ArrayList` objects, we just need to declare an `ArrayList` variable, like this example from the `NotesCreate2.java` file:

```java
ArrayList list = new ArrayList();
```

Just like `arr` was a very common name for array variables in varying situations, `list` is likewise a very common name for `ArrayList` variables in varying situations.

We discussed above how by default, an `ArrayList` does not have a singular type it works with, and can accept values of any type. The `ArrayList` object and variable we have created here are this default version. So how do we assign a type to the `ArrayList`? With arrays, it was when we created it (but then again, we also never wrote "array", it was always the square bracket notation).

With `ArrayList` objects, it is also *typed* at creation, so we would define the type that it accepts when we create it. This means that our previous example is stuck as a general `ArrayList`, instead of only accepting a specific type. To assign a type to our `ArrayList`, we introduce the angle bracket `< >` notation. Here is what this would like like in general from the `NotesCreate3.java` file:

```java
ArrayList<E> list = new ArrayList<E>();
```

While this example doesn't work (because `E` isn't a type), it shows how and where the angle brackets are used. Both the variable declaration (left side) and the the object creation (right side) need the angle brackets specifying the type, and they need to match. Also note how the angle brackets come before the contructor parentheses on the right side. Replacing `E` in our example with any type we want to assign allows us to create a *pickier* `ArrayList`.

Here are some examples of `ArrayList` objects constructed for various types from the `NotesCreate4.java` file:

```java
ArrayList<Integer> intList = new ArrayList<Integer>();
ArrayList<Double> doubleList = new ArrayList<Double>();
ArrayList<String> stringList = new ArrayList<String>();
ArrayList<Person> peopleList = new ArrayList<Person>();
```

Note the use of the wrapper classes `Integer` and `Double` for `int` and `double` respectively.

---

## How to Use an `ArrayList`

Interacting with an `ArrayList` is very different from an array due to the use of methods. Despite this, there should be a level of comfort as we are very familiar with methods from all of our work with classes and objects!

### `public int size()`

Just like with arrays, a typical question for an `ArrayList` is "how many elements is it storing?". In an array, this was the property `length`, and would never change once an array had been created. In an `ArrayList`, we use the method `size()` to access the same information. It is a `public` method, so it is accessible to us and its `return` type is `int`, so it provides the number of stored elements as an `int`.

Here is an example of this method from the `NotesSize1.java` file:

```java
ArrayList<Integer> intList = new ArrayList<Integer>();
System.out.println(intList.size());
```

This produces the output `0`, as initialized `ArrayList` objects start with `0` elements.

### `public boolean add(E obj)`

If an `ArrayList` starts empty, we need to be able to add objects to it. There are two ways to do this, but the first one is this `add` method. It is a `public` method, so it is accessible to us.

It takes a parameter, marked above as `E obj`. You might have noticed earlier that I had used `E` for our generic example of how to assign a type to an `ArrayList` and this was not just a random choice. Since ArrayList objects can be used with any type, these functions are designed to handle any type, though they do lock down and choose one when the `ArrayList` is assigned a type. For example, if the `ArrayList` was assigned the type `Integer`, then this method would take the parameter `Integer obj`.

This method takes the parameter `obj` and attaches, or **appends** it to the end of the list as it currently stands. This means that it will be assigned to the next possible index. If there had been `4` elements, and therefore the last element had an index of `3`, then adding another object would get the index `4`, and the size would now be `5`.

While not typically used, this method does have a `return` type of `boolean`, which is guaranteed to `return` `true`.

Here is an example of this method from the `NotesAdd1.java` file:

```java
ArrayList<Double> doubleList = new ArrayList<Double>();
doubleList.add(5.2);
System.out.println(doubleList.add(-4.7));
```

This produces the output `true`. The value `5.2` is added to the empty list, getting assigned index `0`, and the value `4.7` is added to the one-element list, getting assigned index `1`.

Typically, we would just use the `add` method on its own line like in the first example, but it is possible to utilize the `return` value to print (as seen above) or satisfy any `boolean` condition.

### `public void add(int index, E obj)`

While adding objects to the end of an `ArrayList` is great, it might also be necessary sometimes to insert an object into the middle of the `ArrayList`. It makes sense that we would do this by providing an index that we want the new object to be inserted at, but what would happen to the object that is already at that index, or the objects near it? In an array, that object would get replaced, as we couldn't just move all elements out of the way. With `ArrayList` objects being mutable though, that is exactly what we can do!

This version of the `add` method is again a `public` method so we can use it, and it takes two parameters: an `int` that represents the index first, and an `E` object that is the object to be added at that index. Again, the object of type `E` should match the type of `ArrayList`. This time, there is no `return` from this `add` method, so we cannot utilize that same `boolean` logic if we had wanted to.

Here is what the call `add(2, 9)` might look like visually:

```
Index:      0   1   2   3   4
Original:   5   8   3   1
Updated:    5   8   9   3   1
```

The add method will insert the provided object (the `Integer` `9`) at the provided index (the `int` `2`), and move all objects from that index onwards to the right by one slot. So the object that was at index `2` in this example, got moved to index `3`, the object at index `3` to index `4`, and would continue on until all objects have been moved to the right!

Just like adding an element to the end, this method will increase the `size()` of the `ArrayList` by `1`, since there is one more element than before.

Interestingly, the highest allowed index for this method is the value of `size()` itself. This seems wrong because `size()` is not a valid index (in the above example, `size()` was `4`, but there was no index `4` until we added the element). This being allowed means you can use this version of the method to add an element to the end of the list if needed, since a call with index `3` here would have still shifted the last item to the right. It is typically preferred to use the simpler version of the `add` method to append an element to the end of the list, but this can work if needed!

Here is an example of this method from the `NotesAdd2.java` file:

```java
ArrayList<String> strList = new ArrayList<String>();
strList.add("Hi");
strList.add("Hello");
strList.add("Hey");
// The list is currently ["Hi", "Hello", "Hey"]
strList.add(1, "Yo");
// Now the list is ["Hi", "Yo", "Hello", "Hey"]
strList.add(strList.size(), "Hola");
// Now the list is ["Hi", "Yo", "Hello", "Hey", "Hola"]
```

This shows three normal additions to the `ArrayList` so that we have some elements to shift around, and then an insertion at index `1`, and then utilizing `size()` to put another element at the end of the `ArrayList`.

### `public E get(int index)`

While adding elements to an `ArrayList` is helpful, this is only useful if we can get our values back out of our `ArrayList`. This is where the method `get` comes into play. This is a `public` method for us to use.

With similar naming to our traditional accessor methods, `get` will get us an element from the `ArrayList`, specified by the `int` parameter `index`. The `return` type of this method is `E`, as the type of information it is going to send to us is going to match the type of the `ArrayList`.

Here is an example of this method from the `NotesGet1.java` file:

```java
ArrayList<Person> peopleList = new ArrayList<Person>();
peopleList.add(new Person("Mr. G", 25));
peopleList.add(new Person("Sam", 34));
peopleList.add(new Person("Will", 26));
System.out.println(peopleList.get(2));
System.out.println(peopleList.get(1).getName());
System.out.println(peopleList.get(0).getAge());
```

In this example, we create three different `Person` objects and add them to our `ArrayList`. The first print statement produces the output `"Will is 26 years old."` because `strList.get(2)` returns the `Person` object, and when the `Person` object is printed, its `toString()` method is automatically called. Similarly, the second and third print statements print `"Sam"` and `25` respectively, because they return their `Person` objects, and then use the dot operator `.` to call methods `getName()` and `getAge()` respectively. This offers us a lot of possibilities as we get information from an `ArrayList`, just like arrays.

### `public E set(int index, E obj)`

While adding objects anywhere in an `ArrayList` is useful, sometimes we want to actually replace an element, rather than just moving everything over. This is where the `set` method comes into play. This is a `public` method for us to use.

With similar naming to our traditional mutator methods, `set` will set an element in the `ArrayList`, with where specified by the `int` parameter `index`, and what to set specified by the `E` parameter `obj`. As usual, the type `E` matches the type of our `ArrayList`. This is similar parameters to our extended `add` method, and the difference this time is that it replaces the element at that position, rather than shift everything over. This means that `size()` is not a valid index for this method, as that index wouldn't already exist and therefore have no element to replace.

The other difference is the `return` type of this method, which is `E`, matching the type of the `ArrayList`. While we pass in a new object as the parameter `obj`, the method also returns a value of the same type; specifically, it returns the value that was stored at that index before the replacement. While not utilized all the time, this gives us an opportunity to do something with that information before it disappears forever. When this method returns the element previously at that position, it has already been replaced by the new `obj`, meaning this is our last opportunity to do something with that information if needed.

Here is an example of this method from the `NotesSet1.java` file:

```java
ArrayList<Integer> intList = new ArrayList<Integer>();
intList.add(152);
intList.add(234);
intList.add(876);
intList.set(1, 900);
System.out.println(intList.set(2, 654));
```

In this example, we create three different `Integer` objects and add them to our `ArrayList`. Our first `set` method call replaces the value `234` (the element at index `1`) with the new value of `900`. This method call does `return` the value `234` that was sitting there, but since we don't do anything with it, it disappears, and is now forgotten. The second `set` method call replaces the value `876` (the element at index `2`) with the value of `654`. Since it is in a print statement, the `return` value is utilized and the previous value `876` is printed out.

This `return` value offers a unique opportunity to swap elements in and out of an `ArrayList` in a way that was not possible with arrays. Here is an example of this behavior from the `NotesSet2.java` file:

```java
ArrayList<Double> doubleList = new ArrayList<Double>();
doubleList.add(67.2);
double val = 21.4;

val = doubleList.set(0, val);
System.out.println(doubleList.get(0) + " " + val);

val = doubleList.set(0, val);
System.out.println(doubleList.get(0) + " " + val);

val = doubleList.set(0, val);
System.out.println(doubleList.get(0) + " " + val);
```

In this example, we only need to add a single `Double` element to our `ArrayList` to experiment. We then create a `double` variable `val` to store a value separately from the `ArrayList`. Now based on the behavior of the `set` method and assignment, we should be able to use `set` to set the value in the `ArrayList` to the value stored in the variable, and then use the `return` of the `set` method with assignment to reassign the variable in the same line of code. This ends up being the line `val = doubleList.set(0, val)`.

How does it process this one line of code? Using operator precedence. According to operator precedence, assignment `=` comes last, so we first process everything to the right of the assignment, which is `doubleList.set(0, val)`. This replaces the value in the `ArrayList` with the value from `val`, and returns the value that was just replaced in the `ArrayList`. This means that now our assignment is `val = /* previous value from ArrayList */;` and it saves the value from the `ArrayList`. So now the value from `val` is in the `ArrayList` and the value from the `ArrayList` is in `val`, so they have successfully swapped places! This is one of the few times we can swap two values between variables without an intermediate third variable.

The code above does the swap three times and prints the results each time. We can watch the two values `67.2` and `21.4` alternate back and forth with the output:

```
21.4 67.2
67.2 21.4
21.4 67.2
```

### `public E remove(int index)`

With the ability to add, get, and modify, the only tool we are missing is the ability to just completely remove an element. We could replace an element with a default version or `null` with our current tools, but then there's an empty index. It would be better if we could just remove the index entirely. This is what the `remove` method does for us. It is a `public` method for us to use.

Just like our `add` method can insert a new element and shift all the indices to the right (increasing them), the `remove` method can remove an element and shift all the indices to the left (decreasing them). Also similar to `add`, it will change the value of `size()` to decrease by `1`, since there is now one less element.

It takes an `int` parameter representing the index to be removed. It also has a `return` type of `E`, matching the type of the `ArrayList`. Specifically, it returns the object that was stored at the index that was just removed, similar to the `set` method did.

Here is an example of this method from the `NotesSet1.java` file:

```java
ArrayList<String> strList = new ArrayList<String>();
strList.add("Hi");
strList.add("Hey");
strList.add("Hello");
// The ArrayList is ["Hi", "Hey", "Hello"]
strList.remove(1);
// Now the ArrayList is ["Hi", "Hello"]
System.out.println(strList.remove(1));
```

In this example, we first added three `String` objects so that we had some to remove. The first `remove` method call removes the `String` `"Hey"` that had been stored at index `1`. It does `return` the `String` `"Hey"`, but since we don't do anything with it, it disappears. The second `remove` method call at a glance, removes the same `String` again, but because of the shift in indices, the index `1` now refers to the `String` `"Hello"`, and that is removed. The `return` works with the print statement to print out the `String` `"Hello"` after it has been removed.

---

## Assignment

Now that you have gone through the notes for this section, you can check out the `Try.md` and `Try.java` files to try a short assignment using this material.
