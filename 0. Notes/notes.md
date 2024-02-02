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
System.out.println(intList.size())
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

The other way to add objects 

---

## Assignment

Now that you have gone through the notes for this section, you can check out the `Try.md` and `Try.java` files to try a short assignment using this material.
