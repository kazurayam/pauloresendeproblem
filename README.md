Complex XPath example for Katalon Studio
=========================================

This is a small Katalon Studio project for demonstration purpose.
You can get the ZIP file in the [Release] page, download it to your PC,
unzip it and open using your Katalon Studio.

I devleoped it using Katalon Studio 7.2.1.

This project was developed to propose a solution to a discussion in the Katalon Forum.

- https://forum.katalon.com/t/settext-object-which-looks-at-parent-and-child/43318

The original question was

>I want to fill in the text in the text field, based on the “title” of the text field on the left (see screenshot). The title on the left I can define as: text equals `Achternaam (zonder diakriet)`


You can try the demo by running "Test Suites/TS1". My `TS1` successfully inputs a text "As you like it" into the `<input>` element with a label `Achternaam (zonder diakriet)`. You can see the [video](https://drive.google.com/file/d/1aMZwjt8LCCa4CunIlAvLdM4J7WXbCTWs/view?usp=sharing) which shows the "TS1" runs.

The key solution was an XPath like this:

```
//td[contains(normalize-space(),'Achternaam (zonder diakriet)')]/following-sibling::td[1]/table/tbody/tr/td/table/tbody/tr[1]/td[3]/span/input
```

Do you understand this? Well, I would admit to say it is very complicated. However, I could not make it shorter, easier because the target HTML structure is compilcated. The complicated HTML requires complicated XPath to search contents inside. You can do reduce the complexity of the AUT.

 
 