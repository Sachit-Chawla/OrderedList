/**
 * Author @ Sachit Singh Chawla, Banner Id: B00865842
 * This program takes inputs for 2  files containing 2 lists and
 * then merge method merges both the lists
 * difference method creates and returns a third list that is an ordered list with the items in list1 that are not in list
 * common method creates and returns a third list that is an ordered list with the items that are common in list1 and list2
 * then all the respective merges are inserted into different txt files
 */

import java.util.Scanner;
    import java.io.*;
    public class OrderedListDemo {
        public static void main(String[] args)throws IOException {
            // main method which takes file inputs and create files which has the merged list in them
            Scanner keyboard = new Scanner ( System.in );


            //Prompt the user to enter two text files, each consisting of words (names) and create two ordered lists
            System.out.print ( "Enter the 1st filename to read from: " );
            String filename1 = keyboard.nextLine ( );
            System.out.print ( "Enter the 2st filename to read from: " );
            String filename2 = keyboard.nextLine ( );

            File file1 = new File ( filename1 );
            File file2 = new File ( filename2 );

            Scanner inputFile1 = new Scanner ( file1 );
            Scanner inputFile2 = new Scanner ( file2 );

            OrderedList<String> list1 = new OrderedList<String> ( );
            OrderedList<String> list2 = new OrderedList<String> ( );

            // creates a list inserts them alphabetically
            while (inputFile1.hasNext ( )) {
                String s = inputFile1.nextLine ( );
                list1.insert ( s );
            }
            inputFile1.close ( );
            while (inputFile2.hasNext ( )) {
                String s = inputFile2.nextLine ( );
                list2.insert ( s );
            }
            inputFile2.close ( );

            //creates the files to write into
            PrintWriter outputFile1 = new PrintWriter(new FileWriter("merged.txt"));
            PrintWriter outputFile2 = new PrintWriter(new FileWriter("diff.txt"));
            PrintWriter outputFile3 = new PrintWriter(new FileWriter("common.txt"));


            OrderedList<String> mergedList = merge ( list1,list2 );
            OrderedList<String> differenceList = difference ( list1,list2 );
            OrderedList<String> commonList = common ( list1,list2 ) ;

            //inserts the result of each merged lists in to respective files element by element
            for (int i = 0; i < mergedList.size ( ); i++) {
                outputFile1.println(mergedList.get ( i ));
            }
            outputFile1.close ();
            for (int i = 0; i < differenceList.size ( ); i++) {
                outputFile2.println(differenceList.get ( i ));
            }
            outputFile2.close();
            for (int i = 0; i < commonList.size ( ) ; i++) {
                outputFile3.println(commonList.get ( i ));
            }
            outputFile3.close ();
            System.out.println("The merge operations are complete and the results are in merged.txt, difference.txt and common.txt");
        }

        /**
         * creates and returns a third list that is a merger of the two ordered lists
         * using 2 finger walking algorithm
         * @param list1 input for first file to be merged
         * @param list2 input for second file to be merged
         * @param <T> Makes the method generic
         * @return the third file with the both files merged
         */
        public static <T extends Comparable<T>> OrderedList<T> merge(OrderedList<T> list1, OrderedList<T>
                list2) {
            OrderedList<T> resultList = new OrderedList<T> ( );
            //cursor variables
            int f1 = 0; // list 1 cursor
            int f2 = 0; // list 2 cursor
            while (f1 < list1.size ( ) && f2 < list2.size ( )) {
                // if element at list1 cursor is greater than list2 cursor then it adds it to result list
                // or if list2 is cursor element is greater than list1 cursor then it adds it to result list
                // or else it adds the list1 item to result list and just increments both cursors
                if ( list1.get ( f1 ).compareTo ( list2.get ( f2 ) ) < 0 ) {
                    resultList.add ( list1.get ( f1 ) );
                    f1++;
                } else if ( list1.get ( f1 ).compareTo ( list2.get ( f2 ) ) > 0 ) {
                    resultList.add ( list2.get ( f2 ) );
                    f2++;
                } else {
                    resultList.add ( list1.get ( f1 ) );
                    f1++;
                    f2++;
                }
            }
             // If list 1 is bigger than list 2 or visa versa it adds the remaining items to the resultlist
            if ( f1 == list1.size ( ) ) {
                while (f2 < list2.size ( )) {
                    resultList.add ( list2.get ( f2 ) );
                    f2++;
                }
            }
            if ( f2 == list2.size ( ) ) {
                while (f1 < list1.size ( )) {
                    resultList.add ( list1.get ( f1 ) );
                    f1++;
                }
            }

        return resultList;
        }
        /**
         * Takes 2 list, creates and returns a third list that is an ordered list with the items in list1 that are not in list2
         * using 2 finger walking algorithm
         * @param list1 1 st list
         * @param list2 2 nd list
         * @param <T> Makes the method Generic
         * @return the List 3 which has items in list1 and are not in list2
         */
        public static <T extends Comparable<T>> OrderedList<T> difference(OrderedList<T> list1, OrderedList<T> list2){
            OrderedList<T> resultList = new OrderedList<T>();
            //cursor variables
            int f1 = 0; // list 1 cursor
            int f2 = 0; // list 2 cursor
            while ((f1<list1.size ())&&(f2 < list2.size ())) {
                // if element at list1 cursor is greater than list2 cursor then it adds it to result list
                // or if list2 is cursor element is greater it just increments to the next element
                // or else just increments both cursor
                if ( list1.get ( f1 ).compareTo ( list2.get ( f2 ) ) < 0 ) {
                    resultList.add ( list1.get ( f1 ) );
                    f1++;
                }
                else if(list2.get ( f2 ).compareTo ( list1.get(f1)) < 0){
                    f2++;
                }
                else {
                  f1++;
                  f2++;
                }
            }
           // If list 1 is bigger than list 2  adds the remaining items to the resultlist
            if(f2== list2.size ( )) {
                while (f1< list2.size ( )){
                    resultList.add(list1.get ( f1 ));
                    f1++;
                }
            }
            return resultList;
        }

        /**
         * creates and returns a third list that is an ordered list with the items that are common in list1 and list2
         * using two finger walking algorithm
         * @param list1 1st list be merged
         * @param list2 2nd list to be merged
         * @param <T> Creates the method generic
         * @return third list that is an ordered list with the items that are common in list1 and list2
         */
        public static <T extends Comparable<T>> OrderedList<T> common(OrderedList<T> list1, OrderedList<T> list2){
            OrderedList<T> resultList = new OrderedList<T>();
            int f1 = 0;
            int f2 = 0;
           while ((f1<list1.size ())&&(f2 < list2.size ())){
               // Sees if the element cursor of list1 is greater than cursor of list2 alphabetically and increments the cursor accordingly
               if ( list1.get ( f1 ).compareTo ( list2.get ( f2 ) ) < 0 ) {
                   f1++;
               }
               else if(list2.get ( f2 ).compareTo ( list1.get(f1)) < 0){
                   f2++;
               }
               else {
                   //if it is common it adds to the result list
                   resultList.add ( list1.get ( f1 ) );
                       f1++;
                       f2++;
               }
           }
           // If list 1 is bigger than list 2  adds the remaining items to the resultlist
            if(f2== list2.size ( )) {
                while (f1< list2.size ( )){
                    resultList.add(list1.get ( f1 ));
                    f1++;
                }
            }
            return resultList;
        }
    }

