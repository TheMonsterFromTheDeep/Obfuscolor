# Obfuscolor
Obfuscolor is a simple experiment that cripples simple flood fill algorithms. Feeding an image through Obfuscolor will modify it in ways essentially undetectable to the human eye but good enough to prevent simple flood fill algorithms from filling more than one pixel at a time.

More sophisticated flood fillers can easily fill these images - for example, GIMP's fill tool, under default settings, works fine on filling an image fed through Obfuscolor.

### Example Case
In the example folder are two images - base.png and nofill.png. base.png is a simple image for testing purposes. Fill tools work as expected when editing base.png. nofill.png looks visually the same, but some fill tools, for example the fill tool in Microsoft Paint, will not work as expected.

### Usage
Obfuscolor is used simply with `java -jar Obfuscolor.jar <path to original image> <path to modified image>`.

As of now, the modified image is always saved in PNG format, so if a different file type is specified, it will not actually be taken into account - the file will be saved in the PNG format anyways. This may be fixed in the future.

`java -jar Obfuscolor.jar help` will display simple information about the program.

### Background
Obfuscolor is very simple - its method for crippling fill tools is simply dividing the image into a grid of pixels of different colors. However, the only color component that is modified is blue - which has very minor visual impact - and it is only modified by 1. This results in two pixels that look visually the same - the human eye, in almost all cases, can not differentiate between two pixels with colors that are very very similar - but that still appear different to simpler flood fill algorithms that do not fill within a certain threshold of the color.

This, of course, is why GIMP's fill tool still works - it doesn't only fill the *same* color, but also *similar* colors.
