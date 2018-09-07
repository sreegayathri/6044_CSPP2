 Save This PageHome » openjdk-7 » java » util » [javadoc | source]
    1   /*
    2    * Copyright (c) 1997, 2010, Oracle and/or its affiliates. All rights reserved.
    3    * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
    4    *
    5    * This code is free software; you can redistribute it and/or modify it
    6    * under the terms of the GNU General Public License version 2 only, as
    7    * published by the Free Software Foundation.  Oracle designates this
    8    * particular file as subject to the "Classpath" exception as provided
    9    * by Oracle in the LICENSE file that accompanied this code.
   10    *
   11    * This code is distributed in the hope that it will be useful, but WITHOUT
   12    * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
   13    * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
   14    * version 2 for more details (a copy is included in the LICENSE file that
   15    * accompanied this code).
   16    *
   17    * You should have received a copy of the GNU General Public License version
   18    * 2 along with this work; if not, write to the Free Software Foundation,
   19    * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
   20    *
   21    * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
   22    * or visit www.oracle.com if you need additional information or have any
   23    * questions.
   24    */
   25   
   26   package java.util;
   27   
   28   /**
   29    * Resizable-array implementation of the <tt>List</tt> interface.  Implements
   30    * all optional list operations, and permits all elements, including
   31    * <tt>null</tt>.  In addition to implementing the <tt>List</tt> interface,
   32    * this class provides methods to manipulate the size of the array that is
   33    * used internally to store the list.  (This class is roughly equivalent to
   34    * <tt>Vector</tt>, except that it is unsynchronized.)
   35    *
   36    * <p>The <tt>size</tt>, <tt>isEmpty</tt>, <tt>get</tt>, <tt>set</tt>,
   37    * <tt>iterator</tt>, and <tt>listIterator</tt> operations run in constant
   38    * time.  The <tt>add</tt> operation runs in <i>amortized constant time</i>,
   39    * that is, adding n elements requires O(n) time.  All of the other operations
   40    * run in linear time (roughly speaking).  The constant factor is low compared
   41    * to that for the <tt>LinkedList</tt> implementation.
   42    *
   43    * <p>Each <tt>ArrayList</tt> instance has a <i>capacity</i>.  The capacity is
   44    * the size of the array used to store the elements in the list.  It is always
   45    * at least as large as the list size.  As elements are added to an ArrayList,
   46    * its capacity grows automatically.  The details of the growth policy are not
   47    * specified beyond the fact that adding an element has constant amortized
   48    * time cost.
   49    *
   50    * <p>An application can increase the capacity of an <tt>ArrayList</tt> instance
   51    * before adding a large number of elements using the <tt>ensureCapacity</tt>
   52    * operation.  This may reduce the amount of incremental reallocation.
   53    *
   54    * <p><strong>Note that this implementation is not synchronized.</strong>
   55    * If multiple threads access an <tt>ArrayList</tt> instance concurrently,
   56    * and at least one of the threads modifies the list structurally, it
   57    * <i>must</i> be synchronized externally.  (A structural modification is
   58    * any operation that adds or deletes one or more elements, or explicitly
   59    * resizes the backing array; merely setting the value of an element is not
   60    * a structural modification.)  This is typically accomplished by
   61    * synchronizing on some object that naturally encapsulates the list.
   62    *
   63    * If no such object exists, the list should be "wrapped" using the
   64    * {@link Collections#synchronizedList Collections.synchronizedList}
   65    * method.  This is best done at creation time, to prevent accidental
   66    * unsynchronized access to the list:<pre>
   67    *   List list = Collections.synchronizedList(new ArrayList(...));</pre>
   68    *
   69    * <p><a name="fail-fast"/>
   70    * The iterators returned by this class's {@link #iterator() iterator} and
   71    * {@link #listIterator(int) listIterator} methods are <em>fail-fast</em>:
   72    * if the list is structurally modified at any time after the iterator is
   73    * created, in any way except through the iterator's own
   74    * {@link ListIterator#remove() remove} or
   75    * {@link ListIterator#add(Object) add} methods, the iterator will throw a
   76    * {@link ConcurrentModificationException}.  Thus, in the face of
   77    * concurrent modification, the iterator fails quickly and cleanly, rather
   78    * than risking arbitrary, non-deterministic behavior at an undetermined
   79    * time in the future.
   80    *
   81    * <p>Note that the fail-fast behavior of an iterator cannot be guaranteed
   82    * as it is, generally speaking, impossible to make any hard guarantees in the
   83    * presence of unsynchronized concurrent modification.  Fail-fast iterators
   84    * throw {@code ConcurrentModificationException} on a best-effort basis.
   85    * Therefore, it would be wrong to write a program that depended on this
   86    * exception for its correctness:  <i>the fail-fast behavior of iterators
   87    * should be used only to detect bugs.</i>
   88    *
   89    * <p>This class is a member of the
   90    * <a href="{@docRoot}/../technotes/guides/collections/index.html">
   91    * Java Collections Framework</a>.
   92    *
   93    * @author  Josh Bloch
   94    * @author  Neal Gafter
   95    * @see     Collection
   96    * @see     List
   97    * @see     LinkedList
   98    * @see     Vector
   99    * @since   1.2
  100    */
  101   
  102   public class ArrayList<E> extends AbstractList<E>
  103           implements List<E>, RandomAccess, Cloneable, java.io.Serializable
  104   {
  105       private static final long serialVersionUID = 8683452581122892189L;
  106   
  107       /**
  108        * The array buffer into which the elements of the ArrayList are stored.
  109        * The capacity of the ArrayList is the length of this array buffer.
  110        */
  111       private transient Object[] elementData;
  112   
  113       /**
  114        * The size of the ArrayList (the number of elements it contains).
  115        *
  116        * @serial
  117        */
  118       private int size;
  119   
  120       /**
  121        * Constructs an empty list with the specified initial capacity.
  122        *
  123        * @param  initialCapacity  the initial capacity of the list
  124        * @throws IllegalArgumentException if the specified initial capacity
  125        *         is negative
  126        */
  127       public ArrayList(int initialCapacity) {
  128           super();
  129           if (initialCapacity < 0)
  130               throw new IllegalArgumentException("Illegal Capacity: "+
  131                                                  initialCapacity);
  132           this.elementData = new Object[initialCapacity];
  133       }
  134   
  135       /**
  136        * Constructs an empty list with an initial capacity of ten.
  137        */
  138       public ArrayList() {
  139           this(10);
  140       }
  141   
  142       /**
  143        * Constructs a list containing the elements of the specified
  144        * collection, in the order they are returned by the collection's
  145        * iterator.
  146        *
  147        * @param c the collection whose elements are to be placed into this list
  148        * @throws NullPointerException if the specified collection is null
  149        */
  150       public ArrayList(Collection<? extends E> c) {
  151           elementData = c.toArray();
  152           size = elementData.length;
  153           // c.toArray might (incorrectly) not return Object[] (see 6260652)
  154           if (elementData.getClass() != Object[].class)
  155               elementData = Arrays.copyOf(elementData, size, Object[].class);
  156       }
  157   
  158       /**
  159        * Trims the capacity of this <tt>ArrayList</tt> instance to be the
  160        * list's current size.  An application can use this operation to minimize
  161        * the storage of an <tt>ArrayList</tt> instance.
  162        */
  163       public void trimToSize() {
  164           modCount++;
  165           int oldCapacity = elementData.length;
  166           if (size < oldCapacity) {
  167               elementData = Arrays.copyOf(elementData, size);
  168           }
  169       }
  170   
  171       /**
  172        * Increases the capacity of this <tt>ArrayList</tt> instance, if
  173        * necessary, to ensure that it can hold at least the number of elements
  174        * specified by the minimum capacity argument.
  175        *
  176        * @param   minCapacity   the desired minimum capacity
  177        */
  178       public void ensureCapacity(int minCapacity) {
  179           if (minCapacity > 0)
  180               ensureCapacityInternal(minCapacity);
  181       }
  182   
  183       private void ensureCapacityInternal(int minCapacity) {
  184           modCount++;
  185           // overflow-conscious code
  186           if (minCapacity - elementData.length > 0)
  187               grow(minCapacity);
  188       }
  189   
  190       /**
  191        * The maximum size of array to allocate.
  192        * Some VMs reserve some header words in an array.
  193        * Attempts to allocate larger arrays may result in
  194        * OutOfMemoryError: Requested array size exceeds VM limit
  195        */
  196       private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
  197   
  198       /**
  199        * Increases the capacity to ensure that it can hold at least the
  200        * number of elements specified by the minimum capacity argument.
  201        *
  202        * @param minCapacity the desired minimum capacity
  203        */
  204       private void grow(int minCapacity) {
  205           // overflow-conscious code
  206           int oldCapacity = elementData.length;
  207           int newCapacity = oldCapacity + (oldCapacity >> 1);
  208           if (newCapacity - minCapacity < 0)
  209               newCapacity = minCapacity;
  210           if (newCapacity - MAX_ARRAY_SIZE > 0)
  211               newCapacity = hugeCapacity(minCapacity);
  212           // minCapacity is usually close to size, so this is a win:
  213           elementData = Arrays.copyOf(elementData, newCapacity);
  214       }
  215   
  216       private static int hugeCapacity(int minCapacity) {
  217           if (minCapacity < 0) // overflow
  218               throw new OutOfMemoryError();
  219           return (minCapacity > MAX_ARRAY_SIZE) ?
  220               Integer.MAX_VALUE :
  221               MAX_ARRAY_SIZE;
  222       }
  223   
  224       /**
  225        * Returns the number of elements in this list.
  226        *
  227        * @return the number of elements in this list
  228        */
  229       public int size() {
  230           return size;
  231       }
  232   
  233       /**
  234        * Returns <tt>true</tt> if this list contains no elements.
  235        *
  236        * @return <tt>true</tt> if this list contains no elements
  237        */
  238       public boolean isEmpty() {
  239           return size == 0;
  240       }
  241   
  242       /**
  243        * Returns <tt>true</tt> if this list contains the specified element.
  244        * More formally, returns <tt>true</tt> if and only if this list contains
  245        * at least one element <tt>e</tt> such that
  246        * <tt>(o==null&nbsp;?&nbsp;e==null&nbsp;:&nbsp;o.equals(e))</tt>.
  247        *
  248        * @param o element whose presence in this list is to be tested
  249        * @return <tt>true</tt> if this list contains the specified element
  250        */
  251       public boolean contains(Object o) {
  252           return indexOf(o) >= 0;
  253       }
  254   
  255       /**
  256        * Returns the index of the first occurrence of the specified element
  257        * in this list, or -1 if this list does not contain the element.
  258        * More formally, returns the lowest index <tt>i</tt> such that
  259        * <tt>(o==null&nbsp;?&nbsp;get(i)==null&nbsp;:&nbsp;o.equals(get(i)))</tt>,
  260        * or -1 if there is no such index.
  261        */
  262       public int indexOf(Object o) {
  263           if (o == null) {
  264               for (int i = 0; i < size; i++)
  265                   if (elementData[i]==null)
  266                       return i;
  267           } else {
  268               for (int i = 0; i < size; i++)
  269                   if (o.equals(elementData[i]))
  270                       return i;
  271           }
  272           return -1;
  273       }
  274   
  275       /**
  276        * Returns the index of the last occurrence of the specified element
  277        * in this list, or -1 if this list does not contain the element.
  278        * More formally, returns the highest index <tt>i</tt> such that
  279        * <tt>(o==null&nbsp;?&nbsp;get(i)==null&nbsp;:&nbsp;o.equals(get(i)))</tt>,
  280        * or -1 if there is no such index.
  281        */
  282       public int lastIndexOf(Object o) {
  283           if (o == null) {
  284               for (int i = size-1; i >= 0; i--)
  285                   if (elementData[i]==null)
  286                       return i;
  287           } else {
  288               for (int i = size-1; i >= 0; i--)
  289                   if (o.equals(elementData[i]))
  290                       return i;
  291           }
  292           return -1;
  293       }
  294   
  295       /**
  296        * Returns a shallow copy of this <tt>ArrayList</tt> instance.  (The
  297        * elements themselves are not copied.)
  298        *
  299        * @return a clone of this <tt>ArrayList</tt> instance
  300        */
  301       public Object clone() {
  302           try {
  303               @SuppressWarnings("unchecked")
  304                   ArrayList<E> v = (ArrayList<E>) super.clone();
  305               v.elementData = Arrays.copyOf(elementData, size);
  306               v.modCount = 0;
  307               return v;
  308           } catch (CloneNotSupportedException e) {
  309               // this shouldn't happen, since we are Cloneable
  310               throw new InternalError();
  311           }
  312       }
  313   
  314       /**
  315        * Returns an array containing all of the elements in this list
  316        * in proper sequence (from first to last element).
  317        *
  318        * <p>The returned array will be "safe" in that no references to it are
  319        * maintained by this list.  (In other words, this method must allocate
  320        * a new array).  The caller is thus free to modify the returned array.
  321        *
  322        * <p>This method acts as bridge between array-based and collection-based
  323        * APIs.
  324        *
  325        * @return an array containing all of the elements in this list in
  326        *         proper sequence
  327        */
  328       public Object[] toArray() {
  329           return Arrays.copyOf(elementData, size);
  330       }
  331   
  332       /**
  333        * Returns an array containing all of the elements in this list in proper
  334        * sequence (from first to last element); the runtime type of the returned
  335        * array is that of the specified array.  If the list fits in the
  336        * specified array, it is returned therein.  Otherwise, a new array is
  337        * allocated with the runtime type of the specified array and the size of
  338        * this list.
  339        *
  340        * <p>If the list fits in the specified array with room to spare
  341        * (i.e., the array has more elements than the list), the element in
  342        * the array immediately following the end of the collection is set to
  343        * <tt>null</tt>.  (This is useful in determining the length of the
  344        * list <i>only</i> if the caller knows that the list does not contain
  345        * any null elements.)
  346        *
  347        * @param a the array into which the elements of the list are to
  348        *          be stored, if it is big enough; otherwise, a new array of the
  349        *          same runtime type is allocated for this purpose.
  350        * @return an array containing the elements of the list
  351        * @throws ArrayStoreException if the runtime type of the specified array
  352        *         is not a supertype of the runtime type of every element in
  353        *         this list
  354        * @throws NullPointerException if the specified array is null
  355        */
  356       @SuppressWarnings("unchecked")
  357       public <T> T[] toArray(T[] a) {
  358           if (a.length < size)
  359               // Make a new array of a's runtime type, but my contents:
  360               return (T[]) Arrays.copyOf(elementData, size, a.getClass());
  361           System.arraycopy(elementData, 0, a, 0, size);
  362           if (a.length > size)
  363               a[size] = null;
  364           return a;
  365       }
  366   
  367       // Positional Access Operations
  368   
  369       @SuppressWarnings("unchecked")
  370       E elementData(int index) {
  371           return (E) elementData[index];
  372       }
  373   
  374       /**
  375        * Returns the element at the specified position in this list.
  376        *
  377        * @param  index index of the element to return
  378        * @return the element at the specified position in this list
  379        * @throws IndexOutOfBoundsException {@inheritDoc}
  380        */
  381       public E get(int index) {
  382           rangeCheck(index);
  383   
  384           return elementData(index);
  385       }
  386   
  387       /**
  388        * Replaces the element at the specified position in this list with
  389        * the specified element.
  390        *
  391        * @param index index of the element to replace
  392        * @param element element to be stored at the specified position
  393        * @return the element previously at the specified position
  394        * @throws IndexOutOfBoundsException {@inheritDoc}
  395        */
  396       public E set(int index, E element) {
  397           rangeCheck(index);
  398   
  399           E oldValue = elementData(index);
  400           elementData[index] = element;
  401           return oldValue;
  402       }
  403   
  404       /**
  405        * Appends the specified element to the end of this list.
  406        *
  407        * @param e element to be appended to this list
  408        * @return <tt>true</tt> (as specified by {@link Collection#add})
  409        */
  410       public boolean add(E e) {
  411           ensureCapacityInternal(size + 1);  // Increments modCount!!
  412           elementData[size++] = e;
  413           return true;
  414       }
  415   
  416       /**
  417        * Inserts the specified element at the specified position in this
  418        * list. Shifts the element currently at that position (if any) and
  419        * any subsequent elements to the right (adds one to their indices).
  420        *
  421        * @param index index at which the specified element is to be inserted
  422        * @param element element to be inserted
  423        * @throws IndexOutOfBoundsException {@inheritDoc}
  424        */
  425       public void add(int index, E element) {
  426           rangeCheckForAdd(index);
  427   
  428           ensureCapacityInternal(size + 1);  // Increments modCount!!
  429           System.arraycopy(elementData, index, elementData, index + 1,
  430                            size - index);
  431           elementData[index] = element;
  432           size++;
  433       }
  434   
  435       /**
  436        * Removes the element at the specified position in this list.
  437        * Shifts any subsequent elements to the left (subtracts one from their
  438        * indices).
  439        *
  440        * @param index the index of the element to be removed
  441        * @return the element that was removed from the list
  442        * @throws IndexOutOfBoundsException {@inheritDoc}
  443        */
  444       public E remove(int index) {
  445           rangeCheck(index);
  446   
  447           modCount++;
  448           E oldValue = elementData(index);
  449   
  450           int numMoved = size - index - 1;
  451           if (numMoved > 0)
  452               System.arraycopy(elementData, index+1, elementData, index,
  453                                numMoved);
  454           elementData[--size] = null; // Let gc do its work
  455   
  456           return oldValue;
  457       }
  458   
  459       /**
  460        * Removes the first occurrence of the specified element from this list,
  461        * if it is present.  If the list does not contain the element, it is
  462        * unchanged.  More formally, removes the element with the lowest index
  463        * <tt>i</tt> such that
  464        * <tt>(o==null&nbsp;?&nbsp;get(i)==null&nbsp;:&nbsp;o.equals(get(i)))</tt>
  465        * (if such an element exists).  Returns <tt>true</tt> if this list
  466        * contained the specified element (or equivalently, if this list
  467        * changed as a result of the call).
  468        *
  469        * @param o element to be removed from this list, if present
  470        * @return <tt>true</tt> if this list contained the specified element
  471        */
  472       public boolean remove(Object o) {
  473           if (o == null) {
  474               for (int index = 0; index < size; index++)
  475                   if (elementData[index] == null) {
  476                       fastRemove(index);
  477                       return true;
  478                   }
  479           } else {
  480               for (int index = 0; index < size; index++)
  481                   if (o.equals(elementData[index])) {
  482                       fastRemove(index);
  483                       return true;
  484                   }
  485           }
  486           return false;
  487       }
  488   
  489       /*
  490        * Private remove method that skips bounds checking and does not
  491        * return the value removed.
  492        */
  493       private void fastRemove(int index) {
  494           modCount++;
  495           int numMoved = size - index - 1;
  496           if (numMoved > 0)
  497               System.arraycopy(elementData, index+1, elementData, index,
  498                                numMoved);
  499           elementData[--size] = null; // Let gc do its work
  500       }
  501   
  502       /**
  503        * Removes all of the elements from this list.  The list will
  504        * be empty after this call returns.
  505        */
  506       public void clear() {
  507           modCount++;
  508   
  509           // Let gc do its work
  510           for (int i = 0; i < size; i++)
  511               elementData[i] = null;
  512   
  513           size = 0;
  514       }
  515   
  516       /**
  517        * Appends all of the elements in the specified collection to the end of
  518        * this list, in the order that they are returned by the
  519        * specified collection's Iterator.  The behavior of this operation is
  520        * undefined if the specified collection is modified while the operation
  521        * is in progress.  (This implies that the behavior of this call is
  522        * undefined if the specified collection is this list, and this
  523        * list is nonempty.)
  524        *
  525        * @param c collection containing elements to be added to this list
  526        * @return <tt>true</tt> if this list changed as a result of the call
  527        * @throws NullPointerException if the specified collection is null
  528        */
  529       public boolean addAll(Collection<? extends E> c) {
  530           Object[] a = c.toArray();
  531           int numNew = a.length;
  532           ensureCapacityInternal(size + numNew);  // Increments modCount
  533           System.arraycopy(a, 0, elementData, size, numNew);
  534           size += numNew;
  535           return numNew != 0;
  536       }
  537   
  538       /**
  539        * Inserts all of the elements in the specified collection into this
  540        * list, starting at the specified position.  Shifts the element
  541        * currently at that position (if any) and any subsequent elements to
  542        * the right (increases their indices).  The new elements will appear
  543        * in the list in the order that they are returned by the
  544        * specified collection's iterator.
  545        *
  546        * @param index index at which to insert the first element from the
  547        *              specified collection
  548        * @param c collection containing elements to be added to this list
  549        * @return <tt>true</tt> if this list changed as a result of the call
  550        * @throws IndexOutOfBoundsException {@inheritDoc}
  551        * @throws NullPointerException if the specified collection is null
  552        */
  553       public boolean addAll(int index, Collection<? extends E> c) {
  554           rangeCheckForAdd(index);
  555   
  556           Object[] a = c.toArray();
  557           int numNew = a.length;
  558           ensureCapacityInternal(size + numNew);  // Increments modCount
  559   
  560           int numMoved = size - index;
  561           if (numMoved > 0)
  562               System.arraycopy(elementData, index, elementData, index + numNew,
  563                                numMoved);
  564   
  565           System.arraycopy(a, 0, elementData, index, numNew);
  566           size += numNew;
  567           return numNew != 0;
  568       }
  569   
  570       /**
  571        * Removes from this list all of the elements whose index is between
  572        * {@code fromIndex}, inclusive, and {@code toIndex}, exclusive.
  573        * Shifts any succeeding elements to the left (reduces their index).
  574        * This call shortens the list by {@code (toIndex - fromIndex)} elements.
  575        * (If {@code toIndex==fromIndex}, this operation has no effect.)
  576        *
  577        * @throws IndexOutOfBoundsException if {@code fromIndex} or
  578        *         {@code toIndex} is out of range
  579        *         ({@code fromIndex < 0 ||
  580        *          fromIndex >= size() ||
  581        *          toIndex > size() ||
  582        *          toIndex < fromIndex})
  583        */
  584       protected void removeRange(int fromIndex, int toIndex) {
  585           modCount++;
  586           int numMoved = size - toIndex;
  587           System.arraycopy(elementData, toIndex, elementData, fromIndex,
  588                            numMoved);
  589   
  590           // Let gc do its work
  591           int newSize = size - (toIndex-fromIndex);
  592           while (size != newSize)
  593               elementData[--size] = null;
  594       }
  595   
  596       /**
  597        * Checks if the given index is in range.  If not, throws an appropriate
  598        * runtime exception.  This method does *not* check if the index is
  599        * negative: It is always used immediately prior to an array access,
  600        * which throws an ArrayIndexOutOfBoundsException if index is negative.
  601        */
  602       private void rangeCheck(int index) {
  603           if (index >= size)
  604               throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
  605       }
  606   
  607       /**
  608        * A version of rangeCheck used by add and addAll.
  609        */
  610       private void rangeCheckForAdd(int index) {
  611           if (index > size || index < 0)
  612               throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
  613       }
  614   
  615       /**
  616        * Constructs an IndexOutOfBoundsException detail message.
  617        * Of the many possible refactorings of the error handling code,
  618        * this "outlining" performs best with both server and client VMs.
  619        */
  620       private String outOfBoundsMsg(int index) {
  621           return "Index: "+index+", Size: "+size;
  622       }
  623   
  624       /**
  625        * Removes from this list all of its elements that are contained in the
  626        * specified collection.
  627        *
  628        * @param c collection containing elements to be removed from this list
  629        * @return {@code true} if this list changed as a result of the call
  630        * @throws ClassCastException if the class of an element of this list
  631        *         is incompatible with the specified collection
  632        * (<a href="Collection.html#optional-restrictions">optional</a>)
  633        * @throws NullPointerException if this list contains a null element and the
  634        *         specified collection does not permit null elements
  635        * (<a href="Collection.html#optional-restrictions">optional</a>),
  636        *         or if the specified collection is null
  637        * @see Collection#contains(Object)
  638        */
  639       public boolean removeAll(Collection<?> c) {
  640           return batchRemove(c, false);
  641       }
  642   
  643       /**
  644        * Retains only the elements in this list that are contained in the
  645        * specified collection.  In other words, removes from this list all
  646        * of its elements that are not contained in the specified collection.
  647        *
  648        * @param c collection containing elements to be retained in this list
  649        * @return {@code true} if this list changed as a result of the call
  650        * @throws ClassCastException if the class of an element of this list
  651        *         is incompatible with the specified collection
  652        * (<a href="Collection.html#optional-restrictions">optional</a>)
  653        * @throws NullPointerException if this list contains a null element and the
  654        *         specified collection does not permit null elements
  655        * (<a href="Collection.html#optional-restrictions">optional</a>),
  656        *         or if the specified collection is null
  657        * @see Collection#contains(Object)
  658        */
  659       public boolean retainAll(Collection<?> c) {
  660           return batchRemove(c, true);
  661       }
  662   
  663       private boolean batchRemove(Collection<?> c, boolean complement) {
  664           final Object[] elementData = this.elementData;
  665           int r = 0, w = 0;
  666           boolean modified = false;
  667           try {
  668               for (; r < size; r++)
  669                   if (c.contains(elementData[r]) == complement)
  670                       elementData[w++] = elementData[r];
  671           } finally {
  672               // Preserve behavioral compatibility with AbstractCollection,
  673               // even if c.contains() throws.
  674               if (r != size) {
  675                   System.arraycopy(elementData, r,
  676                                    elementData, w,
  677                                    size - r);
  678                   w += size - r;
  679               }
  680               if (w != size) {
  681                   for (int i = w; i < size; i++)
  682                       elementData[i] = null;
  683                   modCount += size - w;
  684                   size = w;
  685                   modified = true;
  686               }
  687           }
  688           return modified;
  689       }
  690   
  691       /**
  692        * Save the state of the <tt>ArrayList</tt> instance to a stream (that
  693        * is, serialize it).
  694        *
  695        * @serialData The length of the array backing the <tt>ArrayList</tt>
  696        *             instance is emitted (int), followed by all of its elements
  697        *             (each an <tt>Object</tt>) in the proper order.
  698        */
  699       private void writeObject(java.io.ObjectOutputStream s)
  700           throws java.io.IOException{
  701           // Write out element count, and any hidden stuff
  702           int expectedModCount = modCount;
  703           s.defaultWriteObject();
  704   
  705           // Write out array length
  706           s.writeInt(elementData.length);
  707   
  708           // Write out all elements in the proper order.
  709           for (int i=0; i<size; i++)
  710               s.writeObject(elementData[i]);
  711   
  712           if (modCount != expectedModCount) {
  713               throw new ConcurrentModificationException();
  714           }
  715   
  716       }
  717   
  718       /**
  719        * Reconstitute the <tt>ArrayList</tt> instance from a stream (that is,
  720        * deserialize it).
  721        */
  722       private void readObject(java.io.ObjectInputStream s)
  723           throws java.io.IOException, ClassNotFoundException {
  724           // Read in size, and any hidden stuff
  725           s.defaultReadObject();
  726   
  727           // Read in array length and allocate array
  728           int arrayLength = s.readInt();
  729           Object[] a = elementData = new Object[arrayLength];
  730   
  731           // Read in all elements in the proper order.
  732           for (int i=0; i<size; i++)
  733               a[i] = s.readObject();
  734       }
  735   
  736       /**
  737        * Returns a list iterator over the elements in this list (in proper
  738        * sequence), starting at the specified position in the list.
  739        * The specified index indicates the first element that would be
  740        * returned by an initial call to {@link ListIterator#next next}.
  741        * An initial call to {@link ListIterator#previous previous} would
  742        * return the element with the specified index minus one.
  743        *
  744        * <p>The returned list iterator is <a href="#fail-fast"><i>fail-fast</i></a>.
  745        *
  746        * @throws IndexOutOfBoundsException {@inheritDoc}
  747        */
  748       public ListIterator<E> listIterator(int index) {
  749           if (index < 0 || index > size)
  750               throw new IndexOutOfBoundsException("Index: "+index);
  751           return new ListItr(index);
  752       }
  753   
  754       /**
  755        * Returns a list iterator over the elements in this list (in proper
  756        * sequence).
  757        *
  758        * <p>The returned list iterator is <a href="#fail-fast"><i>fail-fast</i></a>.
  759        *
  760        * @see #listIterator(int)
  761        */
  762       public ListIterator<E> listIterator() {
  763           return new ListItr(0);
  764       }
  765   
  766       /**
  767        * Returns an iterator over the elements in this list in proper sequence.
  768        *
  769        * <p>The returned iterator is <a href="#fail-fast"><i>fail-fast</i></a>.
  770        *
  771        * @return an iterator over the elements in this list in proper sequence
  772        */
  773       public Iterator<E> iterator() {
  774           return new Itr();
  775       }
  776   
  777       /**
  778        * An optimized version of AbstractList.Itr
  779        */
  780       private class Itr implements Iterator<E> {
  781           int cursor;       // index of next element to return
  782           int lastRet = -1; // index of last element returned; -1 if no such
  783           int expectedModCount = modCount;
  784   
  785           public boolean hasNext() {
  786               return cursor != size;
  787           }
  788   
  789           @SuppressWarnings("unchecked")
  790           public E next() {
  791               checkForComodification();
  792               int i = cursor;
  793               if (i >= size)
  794                   throw new NoSuchElementException();
  795               Object[] elementData = ArrayList.this.elementData;
  796               if (i >= elementData.length)
  797                   throw new ConcurrentModificationException();
  798               cursor = i + 1;
  799               return (E) elementData[lastRet = i];
  800           }
  801   
  802           public void remove() {
  803               if (lastRet < 0)
  804                   throw new IllegalStateException();
  805               checkForComodification();
  806   
  807               try {
  808                   ArrayList.this.remove(lastRet);
  809                   cursor = lastRet;
  810                   lastRet = -1;
  811                   expectedModCount = modCount;
  812               } catch (IndexOutOfBoundsException ex) {
  813                   throw new ConcurrentModificationException();
  814               }
  815           }
  816   
  817           final void checkForComodification() {
  818               if (modCount != expectedModCount)
  819                   throw new ConcurrentModificationException();
  820           }
  821       }
  822   
  823       /**
  824        * An optimized version of AbstractList.ListItr
  825        */
  826       private class ListItr extends Itr implements ListIterator<E> {
  827           ListItr(int index) {
  828               super();
  829               cursor = index;
  830           }
  831   
  832           public boolean hasPrevious() {
  833               return cursor != 0;
  834           }
  835   
  836           public int nextIndex() {
  837               return cursor;
  838           }
  839   
  840           public int previousIndex() {
  841               return cursor - 1;
  842           }
  843   
  844           @SuppressWarnings("unchecked")
  845           public E previous() {
  846               checkForComodification();
  847               int i = cursor - 1;
  848               if (i < 0)
  849                   throw new NoSuchElementException();
  850               Object[] elementData = ArrayList.this.elementData;
  851               if (i >= elementData.length)
  852                   throw new ConcurrentModificationException();
  853               cursor = i;
  854               return (E) elementData[lastRet = i];
  855           }
  856   
  857           public void set(E e) {
  858               if (lastRet < 0)
  859                   throw new IllegalStateException();
  860               checkForComodification();
  861   
  862               try {
  863                   ArrayList.this.set(lastRet, e);
  864               } catch (IndexOutOfBoundsException ex) {
  865                   throw new ConcurrentModificationException();
  866               }
  867           }
  868   
  869           public void add(E e) {
  870               checkForComodification();
  871   
  872               try {
  873                   int i = cursor;
  874                   ArrayList.this.add(i, e);
  875                   cursor = i + 1;
  876                   lastRet = -1;
  877                   expectedModCount = modCount;
  878               } catch (IndexOutOfBoundsException ex) {
  879                   throw new ConcurrentModificationException();
  880               }
  881           }
  882       }
  883   
  884       /**
  885        * Returns a view of the portion of this list between the specified
  886        * {@code fromIndex}, inclusive, and {@code toIndex}, exclusive.  (If
  887        * {@code fromIndex} and {@code toIndex} are equal, the returned list is
  888        * empty.)  The returned list is backed by this list, so non-structural
  889        * changes in the returned list are reflected in this list, and vice-versa.
  890        * The returned list supports all of the optional list operations.
  891        *
  892        * <p>This method eliminates the need for explicit range operations (of
  893        * the sort that commonly exist for arrays).  Any operation that expects
  894        * a list can be used as a range operation by passing a subList view
  895        * instead of a whole list.  For example, the following idiom
  896        * removes a range of elements from a list:
  897        * <pre>
  898        *      list.subList(from, to).clear();
  899        * </pre>
  900        * Similar idioms may be constructed for {@link #indexOf(Object)} and
  901        * {@link #lastIndexOf(Object)}, and all of the algorithms in the
  902        * {@link Collections} class can be applied to a subList.
  903        *
  904        * <p>The semantics of the list returned by this method become undefined if
  905        * the backing list (i.e., this list) is <i>structurally modified</i> in
  906        * any way other than via the returned list.  (Structural modifications are
  907        * those that change the size of this list, or otherwise perturb it in such
  908        * a fashion that iterations in progress may yield incorrect results.)
  909        *
  910        * @throws IndexOutOfBoundsException {@inheritDoc}
  911        * @throws IllegalArgumentException {@inheritDoc}
  912        */
  913       public List<E> subList(int fromIndex, int toIndex) {
  914           subListRangeCheck(fromIndex, toIndex, size);
  915           return new SubList(this, 0, fromIndex, toIndex);
  916       }
  917   
  918       static void subListRangeCheck(int fromIndex, int toIndex, int size) {
  919           if (fromIndex < 0)
  920               throw new IndexOutOfBoundsException("fromIndex = " + fromIndex);
  921           if (toIndex > size)
  922               throw new IndexOutOfBoundsException("toIndex = " + toIndex);
  923           if (fromIndex > toIndex)
  924               throw new IllegalArgumentException("fromIndex(" + fromIndex +
  925                                                  ") > toIndex(" + toIndex + ")");
  926       }
  927   
  928       private class SubList extends AbstractList<E> implements RandomAccess {
  929           private final AbstractList<E> parent;
  930           private final int parentOffset;
  931           private final int offset;
  932           int size;
  933   
  934           SubList(AbstractList<E> parent,
  935                   int offset, int fromIndex, int toIndex) {
  936               this.parent = parent;
  937               this.parentOffset = fromIndex;
  938               this.offset = offset + fromIndex;
  939               this.size = toIndex - fromIndex;
  940               this.modCount = ArrayList.this.modCount;
  941           }
  942   
  943           public E set(int index, E e) {
  944               rangeCheck(index);
  945               checkForComodification();
  946               E oldValue = ArrayList.this.elementData(offset + index);
  947               ArrayList.this.elementData[offset + index] = e;
  948               return oldValue;
  949           }
  950   
  951           public E get(int index) {
  952               rangeCheck(index);
  953               checkForComodification();
  954               return ArrayList.this.elementData(offset + index);
  955           }
  956   
  957           public int size() {
  958               checkForComodification();
  959               return this.size;
  960           }
  961   
  962           public void add(int index, E e) {
  963               rangeCheckForAdd(index);
  964               checkForComodification();
  965               parent.add(parentOffset + index, e);
  966               this.modCount = parent.modCount;
  967               this.size++;
  968           }
  969   
  970           public E remove(int index) {
  971               rangeCheck(index);
  972               checkForComodification();
  973               E result = parent.remove(parentOffset + index);
  974               this.modCount = parent.modCount;
  975               this.size--;
  976               return result;
  977           }
  978   
  979           protected void removeRange(int fromIndex, int toIndex) {
  980               checkForComodification();
  981               parent.removeRange(parentOffset + fromIndex,
  982                                  parentOffset + toIndex);
  983               this.modCount = parent.modCount;
  984               this.size -= toIndex - fromIndex;
  985           }
  986   
  987           public boolean addAll(Collection<? extends E> c) {
  988               return addAll(this.size, c);
  989           }
  990   
  991           public boolean addAll(int index, Collection<? extends E> c) {
  992               rangeCheckForAdd(index);
  993               int cSize = c.size();
  994               if (cSize==0)
  995                   return false;
  996   
  997               checkForComodification();
  998               parent.addAll(parentOffset + index, c);
  999               this.modCount = parent.modCount;
 1000               this.size += cSize;
 1001               return true;
 1002           }
 1003   
 1004           public Iterator<E> iterator() {
 1005               return listIterator();
 1006           }
 1007   
 1008           public ListIterator<E> listIterator(final int index) {
 1009               checkForComodification();
 1010               rangeCheckForAdd(index);
 1011               final int offset = this.offset;
 1012   
 1013               return new ListIterator<E>() {
 1014                   int cursor = index;
 1015                   int lastRet = -1;
 1016                   int expectedModCount = ArrayList.this.modCount;
 1017   
 1018                   public boolean hasNext() {
 1019                       return cursor != SubList.this.size;
 1020                   }
 1021   
 1022                   @SuppressWarnings("unchecked")
 1023                   public E next() {
 1024                       checkForComodification();
 1025                       int i = cursor;
 1026                       if (i >= SubList.this.size)
 1027                           throw new NoSuchElementException();
 1028                       Object[] elementData = ArrayList.this.elementData;
 1029                       if (offset + i >= elementData.length)
 1030                           throw new ConcurrentModificationException();
 1031                       cursor = i + 1;
 1032                       return (E) elementData[offset + (lastRet = i)];
 1033                   }
 1034   
 1035                   public boolean hasPrevious() {
 1036                       return cursor != 0;
 1037                   }
 1038   
 1039                   @SuppressWarnings("unchecked")
 1040                   public E previous() {
 1041                       checkForComodification();
 1042                       int i = cursor - 1;
 1043                       if (i < 0)
 1044                           throw new NoSuchElementException();
 1045                       Object[] elementData = ArrayList.this.elementData;
 1046                       if (offset + i >= elementData.length)
 1047                           throw new ConcurrentModificationException();
 1048                       cursor = i;
 1049                       return (E) elementData[offset + (lastRet = i)];
 1050                   }
 1051   
 1052                   public int nextIndex() {
 1053                       return cursor;
 1054                   }
 1055   
 1056                   public int previousIndex() {
 1057                       return cursor - 1;
 1058                   }
 1059   
 1060                   public void remove() {
 1061                       if (lastRet < 0)
 1062                           throw new IllegalStateException();
 1063                       checkForComodification();
 1064   
 1065                       try {
 1066                           SubList.this.remove(lastRet);
 1067                           cursor = lastRet;
 1068                           lastRet = -1;
 1069                           expectedModCount = ArrayList.this.modCount;
 1070                       } catch (IndexOutOfBoundsException ex) {
 1071                           throw new ConcurrentModificationException();
 1072                       }
 1073                   }
 1074   
 1075                   public void set(E e) {
 1076                       if (lastRet < 0)
 1077                           throw new IllegalStateException();
 1078                       checkForComodification();
 1079   
 1080                       try {
 1081                           ArrayList.this.set(offset + lastRet, e);
 1082                       } catch (IndexOutOfBoundsException ex) {
 1083                           throw new ConcurrentModificationException();
 1084                       }
 1085                   }
 1086   
 1087                   public void add(E e) {
 1088                       checkForComodification();
 1089   
 1090                       try {
 1091                           int i = cursor;
 1092                           SubList.this.add(i, e);
 1093                           cursor = i + 1;
 1094                           lastRet = -1;
 1095                           expectedModCount = ArrayList.this.modCount;
 1096                       } catch (IndexOutOfBoundsException ex) {
 1097                           throw new ConcurrentModificationException();
 1098                       }
 1099                   }
 1100   
 1101                   final void checkForComodification() {
 1102                       if (expectedModCount != ArrayList.this.modCount)
 1103                           throw new ConcurrentModificationException();
 1104                   }
 1105               };
 1106           }
 1107   
 1108           public List<E> subList(int fromIndex, int toIndex) {
 1109               subListRangeCheck(fromIndex, toIndex, size);
 1110               return new SubList(this, offset, fromIndex, toIndex);
 1111           }
 1112   
 1113           private void rangeCheck(int index) {
 1114               if (index < 0 || index >= this.size)
 1115                   throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
 1116           }
 1117   
 1118           private void rangeCheckForAdd(int index) {
 1119               if (index < 0 || index > this.size)
 1120                   throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
 1121           }
 1122   
 1123           private String outOfBoundsMsg(int index) {
 1124               return "Index: "+index+", Size: "+this.size;
 1125           }
 1126   
 1127           private void checkForComodification() {
 1128               if (ArrayList.this.modCount != this.modCount)
 1129                   throw new ConcurrentModificationException();
 1130           }
 1131       }
 1132   }

  Save This Page Home » openjdk-7 » java » util » [javadoc | source]