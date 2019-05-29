# Github Avatar Generator

Generate github-style avatar with java awt.

This project is inspired by [gabrie-allaigre/avatar-generator](https://github.com/gabrie-allaigre/avatar-generator).

### Example

![](/img/01.png)

### Build Setup

```bash
# install to local repository
mvn install
```

```xml
<dependency>
    <groupId>com.iustu</groupId>
    <artifactId>github-avatar-generator</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```

### API

#### Configuration

|Method|Description|Default|
|---|---|---|
|setPadding(int padding)|Set the padding of the avatar|32|
|setCellCount(int cellCount)|Set the number of cells of the avatar|5|
|setCellSize(int cellSize)|Set the size of each cell, both length and height of each cell are set to it|64|
|setForeColor(Color color)|Set the foreground color of the avatar|random|
|setForeColors(Color... colors)|Set the foreground color set, the final foreground color will be chosen at random in it|random|
|setForeColors(List<Color> colors)|Set the foreground color set, the final foreground color will be chosen at random in it|random|
|setTransparent(boolean transparent)|Set the transparency of the avatar|false|
|setBackColor(Color color)|Set the background color of the avatar|Color(241, 241, 241)|



