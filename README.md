# ConfirmDialog

<img src="https://raw.githubusercontent.com/alipapital/ConfirmDialog/master/files/confirm_dialog.png" width="500">


#### Step 1. Add the JitPack repository to your build file
```gradle	
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

<br />

#### Step 2. Add the dependency
```gradle	
	dependencies {
	         implementation 'com.github.alipapital:ConfirmDialog:{version}'
	}
```

<br />

#### Step 3. Create Confirm Dialog

```java
            ConfirmDialog dialog = new ConfirmDialog.Builder(this, "Are you sure to delete item ?")
              .setTypeface(Typeface.SANS_SERIF)
              .setColorPositiveButton(getResources().getColor(R.color.colorPrimary))
              .setColorNegativeButton(getResources().getColor(R.color.gray))
              .setColorTextPositiveButton(getResources().getColor(android.R.color.white))
              .setColorTextNegativeButton(getResources().getColor(android.R.color.tab_indicator_text))
              .setColorRipplePositiveButton(getResources().getColor(android.R.color.white))
              .setColorRippleNegativeButton(getResources().getColor(R.color.colorPrimary))
              .setIcon(R.drawable.ic_alert)
              .setIconColor(ContextCompat.getColor(this, android.R.color.holo_red_dark))
              .setMessageBody("For more information about this library, read the document in github.")
              .setPositiveButtonListener("Positive", new OnClickListener() {
                 @Override
                 public void onClick(DialogFragment dialog, View view) {
                    Toast.makeText(MainActivity.this, "Positive Button Clicked", Toast.LENGTH_SHORT).show();
                 }
              })
              .setNegativeButtonListener("Negative", new OnClickListener() {
                 @Override
                 public void onClick(DialogFragment dialog, View view) {
                    Toast.makeText(MainActivity.this, "Negative Button Clicked", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                 }
              })
              .build();
      
      dialog.show(getSupportFragmentManager(), null);
```
           
<br />  
 
#### How to close Confirm Dialog ?
```
      dialog.dismiss();
```
