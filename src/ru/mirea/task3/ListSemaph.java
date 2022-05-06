package ru.mirea.task3;

import java.util.*;
import java.util.concurrent.Semaphore;

public class ListSemaph<E> implements List<E> {
    /**
     * Семафор — это средство для синхронизации доступа к какому-то ресурсу.
     * Его особенность заключается в том, что при создании механизма синхронизации он использует счетчик.
     * Счетчик указывает нам, сколько потоков одновременно могут получать доступ к общему ресурсу.
     * */

    private Semaphore semaphore = new Semaphore(1, true);
    /**
     * int permits — начальное и максимальное значение счетчика.
     * То есть то, сколько потоков одновременно могут иметь доступ к общему ресурсу;
     *
     * boolean fair — для установления порядка, в котором потоки будут получать доступ.
     * Если fair = true, доступ предоставляется ожидающим потокам в том порядке, в котором они его запрашивали.
     * Если же он равен false, порядок будет определять планировщик потоков.*/
    private volatile List<E> list = new ArrayList<>();

    //для методов - Для получения разрешения у семафора надо вызвать метод acquire()
    //После окончания работы с ресурсом полученное ранее разрешение надо освободить с помощью метода release():
    @Override
    public int size() {
        int size = 0;
        try {
            semaphore.acquire();
            size = list.size();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
        return  size;

    }

    @Override
    public boolean isEmpty() {
        boolean emptiness = true;

        try {
            semaphore.acquire();
            emptiness = list.isEmpty();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
        return emptiness;
    }

    @Override
    public boolean contains(Object o) {
        boolean temp = false;
        try {
            semaphore.acquire();
            temp = list.contains(o);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
        return  temp;
    }

    @Override
    public Iterator<E> iterator() {
        Iterator<E> iterator = null;
        try {
            semaphore.acquire();
            iterator = list.iterator();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
        return  iterator;
    }

    @Override
    public Object[] toArray() {
        Object[] objects = new Object[]{};
        try {
            semaphore.acquire();
            objects = list.toArray();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
        return objects;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        Object[] objects = new Object[]{};
        try {
            semaphore.acquire();
            objects = list.toArray();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
        return  (T[]) objects;
    }

    @Override
    public boolean add(E e) {
        boolean add_status = false;
        try {
            semaphore.acquire();
            add_status = list.add(e);
        } catch (InterruptedException er) {
            er.printStackTrace();
        }finally {
            semaphore.release();
        }
        return  add_status;
    }

    @Override
    public boolean remove(Object o) {
        boolean remove_status = false;
        try {
            semaphore.acquire();
            remove_status = list.remove(o);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
        return  remove_status;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        boolean contains_status = false;
        try {
            semaphore.acquire();
            contains_status = list.containsAll(c);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
        return contains_status;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean add_All = false;
        try {
            semaphore.acquire();
            add_All = list.addAll(c);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
        return  add_All;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        boolean add_status = false;
        try {
            semaphore.acquire();
            add_status = list.addAll(index,c);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
        return  add_status;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean removeAllStatus = false;
        try {
            semaphore.acquire();
            removeAllStatus = list.removeAll(c);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
        return  removeAllStatus;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean status = false;
        try {
            semaphore.acquire();
            status = list.retainAll(c);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
        return  status;
    }

    @Override
    public void clear() {
        try {
            semaphore.acquire();
            list.clear();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
    }

    @Override
    public E get(int index) {
        Object object = null;
        try {
            semaphore.acquire();
            object = list.get(index);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
        return (E) object;
    }

    @Override
    public E set(int index, E element) {
        Object object = null;
        try {
            semaphore.acquire();
            object = list.set(index,element);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
        return (E) object;
    }

    @Override
    public void add(int index, E element) {
        boolean status = false;
        try {
            semaphore.acquire();
            list.add(index,element);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
    }

    @Override
    public E remove(int index) {
        Object object = null;
        boolean status = false;
        try {
            semaphore.acquire();
            object = list.remove(index);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
        return (E) object;
    }

    @Override
    public int indexOf(Object o) {
        int index = -1;
        boolean status = false;
        try {
            semaphore.acquire();
            index = list.lastIndexOf(o);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
        return index;
    }

    @Override
    public int lastIndexOf(Object o) {
        int index = -1;
        try {
            semaphore.acquire();
            index = list.lastIndexOf(o);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
        return  index;
    }

    @Override
    public ListIterator<E> listIterator() {
        ListIterator<E> listIt = null;
        boolean status = false;
        try {
            semaphore.acquire();
            listIt = list.listIterator();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
        return listIt;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        ListIterator<E> listIt = null;
        boolean status = false;
        try {
            semaphore.acquire();
            listIt = list.listIterator(index);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
        return listIt;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        boolean status = false;
        List<E> subList = null;
        try {
            semaphore.acquire();
            subList = list.subList(fromIndex,toIndex);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
        return subList;
    }
}
