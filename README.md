# Github Avatar Generator

Generate github-style avatar with java awt.

This project was inspired by [gabrie-allaigre/avatar-generator](https://github.com/gabrie-allaigre/avatar-generator).

## Result Set

![](/img/01.png)

## Build Setup

```bash
# install to local repository
mvn install
```

```xml
<dependency>
    <groupId>com.github.afkbrb</groupId>
    <artifactId>github-avatar-generator</artifactId>
    <version>1.0.0</version>
</dependency>
```

## API

### Configuration

|Method|Description|Default|
|---|---|---|
|setPadding(int padding)|Set the padding of the avatar.|32|
|setCellCount(int cellCount)|Set the number of cells of the avatar.|5|
|setCellSize(int cellSize)|Set the size of each cell, both length and height of each cell will be set to it.|64|
|setForeColor(Color color)|Set the foreground color of the avatar.|random|
|setForeColors(Color... colors)|Set the foreground color set, the final foreground color will be chosen at random in it.|random|
|setForeColors(List<Color> colors)|Set the foreground color set, the final foreground color will be chosen at random in it.|random|
|setTransparent(boolean transparent)|Set the transparency of the avatar.|false|
|setBackColor(Color color)|Set the background color of the avatar.|Color(241, 241, 241)|

Notice

> The final foreground color will be decided by the last called setForeColor* method. And if none of these setForeColor* methods are called, the foreground color will be generated at random but will also meet certain conditions to make the color look nice.

### Creation

|Method|Description|
|---|---|
|void build()|Build the avatar, calling the method each time will create a new avatar image at random according to configuration.|
|BufferedImage generateAndGetAvatar()|Generate a new avatar image and return it.|
|void showAvatar()|Show the generated avatar image with local application.|
|void saveAsPNG(String filepath)|Save avatar image as PNG file. The filepath include path and filename, for example, "E:/avatar.png", you should make sure that the path exists.|

## Example

Default

```java
Avatar avatar = new Avatar();
avatar.showAvatar();
```

Save

```java
Avatar avatar = new Avatar();
avatar.saveAsPNG("E:/avatar.png");
```

Set padding and cell size

```java
AvatarConfig config = new AvatarConfig();
config.setPadding(16);
config.setCellSize(32);
Avatar avatar = new Avatar(config);
avatar.showAvatar();
```

Set the number of cells per row / column

```java
config.setCellCount(8);
```

Set transparency

```java
config.setTransparent(true);
```

Set color
```java
config.setForeColor(Color.MAGENTA);
// config.setBackColor(Color.LIGHT_GRAY);
```

Set colors
```java
config.setForeColors(Color.MAGENTA, Color.BLUE, Color.GREEN);

// the other way
List<Color> colors = new ArrayList<>();
colors.add(Color.YELLOW);
colors.add(Color.ORANGE);
colors.add(Color.CYAN);
config.setForeColors(colors);
```

For more example details, see [example](https://github.com/afkbrb/github-avatar-generator/blob/master/example/Examples.java).

## Licence

[The Apache Software License, Version 2.0](./LICENSE)


