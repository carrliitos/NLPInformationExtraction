# NLP Information Extraction

This is a summer project focusing on Information Exraction

The goal of this project is to be able to automate data/information extraction to create a larger database of CSVs for the medical domain (for our research team in UW-WHITEWATER)

# General Overview of the Pipeline

1. Case reports are crawled from online resources ✓
2. Documents are converted from PDF to text
3. Use of Sentence Classification/Named Entity Recognition from Case Report section of literatures
4. CSV assembly from relevant sentences
5. CSV to DTM analysis

# Sources I am following:

# For all NLP:
1. Natural Language Processing for Information Extraction (Sonit Singh, 2018)
	https://arxiv.org/abs/1807.02383
2. Pipelines for Procedural Information Extraction from Scientific Literature:Towards Recipes using Machine Learning and Data Science (H Yang, 2019)
	https://arxiv.org/pdf/1912.07747.pdf
3. Med7: a transferable clinical natural language processing model for electronic health records (Kormilitzin et al., 2020)
	https://arxiv.org/abs/2003.01271

# For my crawler and text extraction:
4. jsoup: Java HTML Parser
	https://jsoup.org/
5. pdf2txt: extracts text contents of PDF files
	https://github.com/euske/pdfminer

# Text preprocessing:
6. https://www.kdnuggets.com/2017/12/general-approach-preprocessing-text-data.html
7. https://www.kdnuggets.com/2018/08/practitioners-guide-processing-understanding-text-2.html
