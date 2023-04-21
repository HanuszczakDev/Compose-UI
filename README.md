# Compose UI 📺

Simple app concept to train basics of Android Jetpack Compose.

## Features ✨

- Compose

## Project Milestones

### Main Compose Features
- setContent in MainActivity
```
setContent {
    MaterialTheme {
        Surface {
            MainActivityContent()
        }
    }
}
```
- Column
```
Column(
    modifier = Modifier
        .padding(16.dp)
        .fillMaxWidth()
)
```
- Row
```
Row(
    modifier = Modifier
        .fillMaxWidth(),
    horizontalArrangement = Arrangement.Center
)
```
- TextField
```
TextField(
    value = temperature,
    label = {
        Text(text = "Enter temperature in Celsius")
    },
    onValueChange = changed,
    modifier = Modifier
        .fillMaxWidth()
)
```
- Button
```
Button(
    onClick = clicked
) {
    Text(text = "Convert")
}
```
- Image
```
Image(
    painter = painterResource(image),
    contentDescription = description,
    modifier = Modifier
        .height(180.dp)
        .fillMaxWidth(),
    contentScale = ContentScale.Fit
)
```
- Text
```
Text(
    text = "$celsius Celsius is $fahrenheit Fahrenheit"
)
```
- @Preview(showBackground = true)