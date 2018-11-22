# master-promote
- import sdk.
    Step1: 
    Add it in your root build.gradle at the end of repositories: 
    allprojects { 
        repositories { 
        ... 
        maven { url 'https://jitpack.io'} 
        } 
     }

    Step 2: 
    dependencies { 
        implementation 'com.github.ducthanh150796:master-promote:1.0.1' 
    }

- Use.
    PromoteMaster promoteMaster = new PromoteMaster();
    
    promoteMaster.Instance(MainActivity.this, true);
  
