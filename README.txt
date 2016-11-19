Author: SHASHANK RAMGUDE

PURPOSE:
    Using visitors with trees.
    used ANT for the following:
        Compiling the code
        running the code
        Generating a tarball for submission

FILES:
    1) driver/Driver.java
        This is responsible for:
        (1) Validating the command line arguments for input
            and output file names.
        (2) Creating the three visitor instances.
        (3) Creating the element(s).
        (4) Using the performance measurement loop as
             described in the problem statement.
        In the driver code, two visitors are called and the performance is tested.

    2) treesForStrings/AVLTree.java
        This class is responsible for the generation of AVLTrees.
        This class specifies the accept method that in turn calls
        the corresponding visit method. This is required as an
            implementation of the Visitor pattern i.e., in order to
            implement the visitors and bring them into effect.

    3) treesForStrings/AVLNode.java
        This class represents the node of the AVLTree.

    4) util/FileProcessor.java
        This class deals with all the file operations.

    5) util/Logger.java (optional)
        This class implements the debug scheme for this project.
        The debug scheme is as follows: NOOUTPUT , VISITMETHOD , WORDINSERTED , CONSTRUCTOR
        (1) Debug Scheme 0: No printing to stdout
        (2) Debug Scheme 1: Every time control moves to the visit method, print to stdout.
        (3) Debug Scheme 2: Every time a word is inserted into the AVL Tree, print to stdout.
        (4) Debug Scheme 3: Every time a constructor is called, print to stdout.

    6) visitors/PopulateTreeVisitor.java
        This implements the visitor class that is responsible for
        reading from a file and generating an AVL tree with nodes
        containing the words from the file. The file must contain
        one word per file.

    7) visitors/TreeProcessingVisitorI.java
        The Interface that is to be implemented by
        all the visitor classes. These classes in turn
        implement the visit(...) method which is called
        by the appropriate accept method.


    8) visitors/WordCountVisitor.java
        This class implements the visitor that performs
        various operations on the AVLTree, such as determining
        the total number of words, distinct words and characters.

    9) visitors/GrepVisitor.java
        This class is uses string that passed as parameter as a search string.
        it implements the visitor that perform grep operation on input string.

    10) input.txt
        The file containing the words.

    11) README
        The file that you are currently reading.

JUSTIFICATION:
    REASON FOR USING AVL TREE AS DATA STRUCTURE:
    AVL trees are height balancing trees which are more strictly balanced than typically
    Binary Search Trees. For this reason, they provide a faster look-up. They also perform
    insertion of nodes, traversal of the tree and deletion of nodes in O(log n) time.

    For a traversal intensive task, AVL trees can be preferred. Since we perform multiple
    traversal intensive tasks (in the second visitor), AVL trees would provide a
    better performance.

    They are also space efficient. Red-Black trees for instance take up extra space as
    compared to AVL trees.

    The average and worst cases for AVL tree implementation is also O(Log n) for search,
    insertion and deletion operations. Binary Search Trees have a worst case of O(n) for
    search, insertion and deletion operations. This is less favorable when compared with
    AVL trees. All of the above reasons make it a favorable choice
    for the implementation of this assignment.

TO UNTAR:
    To view the content of the created tar file, do the following in Linux command line:
    >tar xvf  bagde_nikhil_assign4.tar
    >tar xvf  ramgude_shashank_assign4.tar

SAMPLE OUTPUT:
    
    1) remote04:~/cs542/projects/bagde_nikhil_assign4/wordCount> ant compile_all
       Buildfile: /import/linux/home/nbagde1/cs542/projects/bagde_nikhil_assign4/wordCount/build.xml

       prepare:
           [mkdir] Created dir: /import/linux/home/nbagde1/cs542/projects/bagde_nikhil_assign4/wordCount/BUILD
           [mkdir] Created dir: /import/linux/home/nbagde1/cs542/projects/bagde_nikhil_assign4/wordCount/BUILD/classes

       wordCount:
           [javac] /import/linux/home/nbagde1/cs542/projects/bagde_nikhil_assign4/wordCount/build.xml:48: warning: 'includeantruntime' was not set, defaulting to build.sysclasspath=last; set to false for repeatable builds
           [javac] Compiling 8 source files to /import/linux/home/nbagde1/cs542/projects/bagde_nikhil_assign4/wordCount/BUILD/classes

       compile_all:

       BUILD SUCCESSFUL
       Total time: 2 seconds

    2) remote04:~/cs542/projects/bagde_nikhil_assign4/wordCount> ant run -Darg0=input.txt -Darg1=output.txt -Darg2=10 -Darg3=the
       Buildfile: /import/linux/home/nbagde1/cs542/projects/bagde_nikhil_assign4/wordCount/build.xml

       jar:

       run:
            [java] Total time utilized: 65

       BUILD SUCCESSFUL
       Total time: 2 seconds

    3) remote04:~/cs542/projects/bagde_nikhil_assign4/wordCount> ant run -Darg0=input.txt -Darg1=output.txt -Darg2=10 -Darg3=the
       Buildfile: /import/linux/home/nbagde1/cs542/projects/bagde_nikhil_assign4/wordCount/build.xml

       jar:

       run:
            [java] Total time utilized: 54

       BUILD SUCCESSFUL
       Total time: 2 seconds

    4) remote04:~/cs542/projects/bagde_nikhil_assign4/wordCount> ant run -Darg0=input.txt -Darg1=output.txt -Darg2=10 -Darg3=the
       Buildfile: /import/linux/home/nbagde1/cs542/projects/bagde_nikhil_assign4/wordCount/build.xml

       jar:

       run:
            [java] Total time utilized: 57

       BUILD SUCCESSFUL
       Total time: 2 seconds

    5) remote04:~/cs542/projects/bagde_nikhil_assign4/wordCount> ant run -Darg0=input.txt -Darg1=output.txt -Darg2=10 -Darg3=the
       Buildfile: /import/linux/home/nbagde1/cs542/projects/bagde_nikhil_assign4/wordCount/build.xml

       jar:

       run:
            [java] Total time utilized: 61

       BUILD SUCCESSFUL
       Total time: 2 seconds

    6) remote04:~/cs542/projects/bagde_nikhil_assign4/wordCount> ant run -Darg0=input.txt -Darg1=output.txt -Darg2=10 -Darg3=the
       Buildfile: /import/linux/home/nbagde1/cs542/projects/bagde_nikhil_assign4/wordCount/build.xml

       jar:

       run:
            [java] Total time utilized: 62

       BUILD SUCCESSFUL
       Total time: 2 seconds

TO COMPILE:

    i) Extract the files from the tarball.
    ii) All scripts and source code is present in the following directory path:
            -bagde_nikhil_assign4/wordCount/src/wordCount/
            where there are multiple directories containing organized java files.
            -To compile and run the code, however, you need to be in the following directory:
            bagde_nikhil_assign4/wordCount/
    iii) Compile all the java files using command (make sure you are in the directory mentioned above)
            ant compile_all
        OR 	ant -buildfile build.xml compile_all

TO RUN:
    Run the files using the following command. Do not forget to include the command line arguments as specified below.

        ant run -Darg0=<input_file_name> -Darg1=<output_file_name> -Darg2=<NUM_ITERATIONS> -Darg3=<search-string>
        OR
        ant -buildfile build.xml run -Darg0=<input_file_name> -Darg1=<output_file_name> -Darg2=<NUM_ITERATIONS> -Darg3=<search-string>

        -Darg0 = <input_file_name>   -  is a String with a .txt extension, from where words are to be accessed.
        -Darg1 = <output_file_name>  -  is a String with a .txt extension, where output would be written.
        -Darg2 = <NUM_ITERATIONS>    -  a positive integer that represents the number of iterations the performance loop should run.
        -Darg3 = <search-string>     -  a positive integer between 0 and 3, that represents the debug level.

    Assuming you are in the directory containing this README:

    ## To clean:
    ant -buildfile build.xml clean
    ## To compile:
    ant -buildfile build.xml all
    ## To run by specifying arguments from command line [similarly for the 2nd argument and so on ...]
    ant -buildfile build.xml run -Darg0=firstarg -Darg1=secondarg -Darg2=thirdarg -Darg3=fourtharg
    ## To run by specifying args in build.xml
    ant -buildfile build.xml run
    ## To create tarball for submission
    ant -buildfile build.xml tarzip

    **Please Note:
    i) The check for the number of command line arguments depends on the name of arguments as specified in the build.xml
        (here, ${arg0}, for example). If the same is changed, the driver code that checks for the number of command line arguments
        will have to be changed accordingly.
    ii) The input.txt file must be in the bagde_nikhil_assign4/wordCount/ directory.


