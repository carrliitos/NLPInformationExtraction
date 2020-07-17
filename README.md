# NLP Information Extraction (In Progress)

This is a summer project focusing on Information Exraction

The goal of this project is to be able to automate data/information extraction to create a larger database of CSVs for the medical domain (for proprietary research in University of Wisconsin - WHITEWATER)

# General Overview of the Pipeline

- [x] Case reports are crawled from online resources ✓
	- Summary:
		- Successfully extracted [223 PDF articles](https://github.com/carrliitos/NLPInformationExtraction/blob/master/src/java/main/preprocessing/textCollection/output1.csv) from [Trauma Case Reports Online Medical Journal Vol. 10 - Vol. 27](https://www.sciencedirect.com/journal/trauma-case-reports). The articles extracted included Editorial Boards from all volumes, which will be removed for NER/Sentence Classification as it is irrelevant for all case reports
- [ ] Documents are converted and cleaned from PDF to text
- [ ] Use of Sentence Classification/Named Entity Recognition from Case Report section of literatures
- [ ] CSV assembly from relevant sentences
- [ ] CSV for proprietary research

# Sources I am following:

## For all NLP:
- [Natural Language Processing for Information Extraction (Sonit Singh, 2018)](https://arxiv.org/abs/1807.02383)
- [Pipelines for Procedural Information Extraction from Scientific Literature:Towards Recipes using Machine Learning and Data Science (H Yang, 2019)](https://arxiv.org/pdf/1912.07747.pdf)
- [Med7: a transferable clinical natural language processing model for electronic health records (Kormilitzin et al., 2020)](https://arxiv.org/abs/2003.01271)

## Text preprocessing:
- [A General Approach to Preprocessing Text Data](https://www.kdnuggets.com/2017/12/general-approach-preprocessing-text-data.html)
- [Text Wrangling & Pre-processing: A Practitioner’s Guide to NLP](https://www.kdnuggets.com/2018/08/practitioners-guide-processing-understanding-text-2.html)
- [All you need to know about text preprocessing for NLP and Machine Learning](https://www.freecodecamp.org/news/all-you-need-to-know-about-text-preprocessing-for-nlp-and-machine-learning-bc1c5765ff67/)

# Tools

## Text Extraction
- [jsoup: Java HTML Parser](https://jsoup.org/)
- [pdf2txt: extracts text contents of PDF files](https://github.com/euske/pdfminer)

## Text Annotation
- [brat rapid annotation tool](http://brat.nlplab.org/)