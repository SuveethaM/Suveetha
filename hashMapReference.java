import java.util.*;
import java.util.Map.Entry;


class Main{
    public static void main(String args[]){
        
        //hashmap is a class used in java collections 
        // hashmap stores the data as key value pairs
        //hashmap keys must be uniQ, the value can be duplicate
        
        // hashmap can be initialized as follows:
        HashMap<Integer,String>hm = new HashMap<>();
        
        
        //put(key, value) is used to put a value into the hashmap;
        hm.put(1,"onnnu");
        hm.put(2,"two");
        hm.put(3,"three");
        hm.put(4,"four");
        hm.put(5,"five");
        
        //since the keys must be uniQ; we are trying to put 1 as key, since 1 is already a key there the previous value is replaced with new value;
        hm.put(1,"one");
   
      
        //we can print the entire hashmap just by its variable name;
        System.out.println(hm);
        //the datatype of the variable is "hashmap";
        System.out.println(((Object)hm).getClass().getSimpleName());
        
        
        //hashmap dont have index we can loop through the elements of the hashmap only using its keys;
        //there are two diff methods: if we want only keys->keySet() if we want only values->values()
        
        //keySet()is used to get only the keys of a hashmap 
        System.out.println("\nkeys: ");
        for(int i:hm.keySet()){
            System.out.println("key->" + i);
        }        
        System.out.println();
        
        
        //values()is used to get only the values of a hashmap 
        System.out.println("values: ");
        for(String i:hm.values()){
            System.out.println("value->" + i);
        }
        System.out.println();
        
        
        //we can access the elements of a hashmap using its key;
        //get(k) method is used to print a value in hashmap:
        System.out.println(hm.get(2));
       
       
        //to find the size of hashmap; size() method is there;
        System.out.println("size of the hashmap is:" + hm.size());
        
      
        //remove(key) method is used to remove an element from hashmap;
        hm.remove(3); //3 value will be removed from the hashmap;
        System.out.println(hm);
        
        //what happens if we try to pass a key which is not present in our map???
        hm.remove(6);  // 6 is not in our hashmap
        System.out.println(hm);
        // as a conc; remove will remove if present; if not present it will just ignore it 
        
        //to clear all the elements of a map and make it empty, clear() method is there;
        hm.clear();
        System.out.println(hm);// returns an empty hashmap 
        
        
        //to make a clone of hashmap; we can use putAll()
        HashMap<Integer,Integer> hm1 = new HashMap<>();
        hm1.put(1,1);
        hm1.put(2,2);
        hm1.put(3,3);
        hm1.put(4,4);
        hm1.put(5,5);
        System.out.println(hm1);
        //creating a new hashmap to clone hm1
        HashMap<Integer,Integer> hm2 = new HashMap<>();
        hm2.putAll(hm1); //its like creating a separate one, so changes made will not affect other copy 
        System.out.println(hm2);
        
        
        //isempty() method to check the map is empty or not:
        System.out.println(hm2.isEmpty());
        hm2.clear();
        System.out.println(hm2.isEmpty());
        
        
        //we have seen that if we use existing key inside put() method it will replace the old one; to overcome this we have a method;
        //putIfAbsent() is used to put values if the key is absent;if key is already present nothing will happen;
        System.out.println("before using putIfAbsent: " + hm1);
        hm1.putIfAbsent(1,10);
        System.out.println("after using putIfAbsent: " + hm1);
        
        
        //to check whether an element is present in map or not we have containsKey() containsValue() methods;
        hm.clear();
        hm.put(1,"one");
        hm.put(2,"one");
        hm.put(3,"one");
        hm.put(4,"one");
        hm.put(5,"one");
        //containsKey()
        System.out.println(hm.containsKey(1));
        System.out.println(hm.containsKey(10));
        
        //containsValue()
        System.out.println(hm.containsValue("one"));
        System.out.println(hm.containsValue("ten"));
        
        //if we want to change the value of an existing value we can use replace() value 
        //replace takes 3 arguments: key, old val(optional), new val;
        System.out.println(hm);
        //replace() will return the old val;
        String replaced = hm.replace(2,"two");
        System.out.println("replaced value: "+replaced);
        System.out.println(hm);
        
        //replaceAll() method is used to change the value of all the values in a map;
        //replaceAll takes one function as argument; and this function takes(k,v) as its argument;
        //the task to be performed as mentioned in this function will be performed to all elements of the map
        System.out.println(hm);
        hm.replaceAll((k,v)->v+" "+String.valueOf(k));
        System.out.println(hm);
        
        
        //if we use get method for an unknown key it will return null value;
        //to make the getmethod to return a default value for unknown keys we have one function getOrDefault()
        System.out.println("key 10 is not present;so default value is: "+hm.getOrDefault(10,"not found"));
        
        //forEach() is similar to replaceALl(); it is also used to perform functions to all the elements of map
        System.out.println();
        hm.forEach((k,v)->{
           System.out.println("old value: "+v);
           v = v + " sridhar";
           System.out.println("new value: "+v);
        });
        System.out.println();
       
        //entrySet() method is used to return all the entries in the map as "Entry" typed set;
        System.out.println(hm.entrySet());
        //we can loop through the entryset as follows:
        System.out.println();
        for(Entry<Integer,String>i:hm.entrySet()) // to use this, we have to "import java.util.Map.Entry;"
        {
            System.out.println("entry set: " + i);
        }
        System.out.println();
        
        
        //we can use merge like replace();
        //merge will take 3 arguments; key,value, action
        System.out.println(hm);
        hm.merge(3,"three",(ov,nv)->nv);
        System.out.println(hm);
        hm.merge(4,"four",(ov,nv)->ov+nv);
        System.out.println(hm);
        
        //keySet() is used to return all the keys in the hashmap as a set;
        //values() is used to return all the values in the hashmap as a set; if values are present more than one time it will be returned as it is; 
        hm.put(6,"one 1");
        System.out.println(hm.values());
        //compute(), computeIfPresent() computeIfAbsent() methods are used compute new value for the given key;
       
    }
}

