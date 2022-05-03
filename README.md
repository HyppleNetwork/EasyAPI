# EasyAPI
_Made for making games more easy_

authors:
 - JernejTDO
 - alandioda (made regions)

## Features
 - Regions (Create regions and use their system)
 - Json File manager (Save files, get body and option to create them)
 - MySQL (Setup the mysql connection and use it)
 - HexColer codes replacer

## Regions
Create a region
 - First you need to make to make 2 locations.
 - Create the region.
 - Last step add the region to the list.
```java
Location loc1 = new Location(Bukkit.getWorld("<World Name>"), 0, 0, 0);
Location loc2 = new Location(Bukkit.getWorld("<World Name>"), 0, 0, 0);
Region region = new Region("<Region Name>", loc1, loc2);
Regions.addRegion(region);
```

Region Events
 - PlayerEnterRegionEvent - When a player joins the region.
 - PlayerExitRegionEvent - When a player leaves a region.
```java
@EventHandler
public void regionEnter(PlayerEnterRegionEvent event) {
}

@EventHandler
public void Region(PlayerExitRegionEvent event) {
}
```

Get info of region.
```java
Region region = null; //Your region
Location loc = null;  //Bukkit location

Regions.addRegion(region); //Adds a region to the plugin.
Regions.deleteRegion(region); //Removes the region from the plugin.
Regions.getRegionInLocation(loc); //Gets the region in that location.
Regions.getRegions(); //List of all the regions created.
Regions.getRegionsByName("<Name>"); //Gets the region by name.
Regions.getRegionsInLocation(loc); //List of all the regions in that location.
```
## Json Manager
You need to use Google`s json dependency.
```html
<dependency>  
    <groupId>com.googlecode.json-simple</groupId>  
    <artifactId>json-simple</artifactId>  
    <version>1.1.1</version>  
</dependency> 
```

 Json Features
```java
import net.hypple.EasyAPI.Json.JsonManager;

JsonManager.createJsonFile("<File Name>");
JsonManager.getJsonBody("<File Name>");
JsonManager.updateJsonBody("<File Name>", JSONObject);
```

## MySQL
Connect to database.
_put in onEnable()_
```java
@Override
public void onEnable() {
	EasyAPI.setupMySQL("Host", "Data Base", "Username", "Password");
}
```

You need to install this dependency
```html
<dependency>
    <groupId>mysql</groupId>
	<artifactId>mysql-connector-java</artifactId>
	<version>8.0.21</version>
</dependency>
```

Get the connection to data base.
```java
EasyAPI.getMySQL().GetConnection();
```

## Hex Coler Codes
Its for the version 1.16+ that support RGB. You can you this on spigot and Bungee servers.
_You just need to put the & symbol in front of the hex code_
```java
Player player = null; //Your player 
player.sendMessage(HexColors.replaceHexCodes("&#00f2ff message in your coler."));
```
