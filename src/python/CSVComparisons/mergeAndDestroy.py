import os
import shutil
import glob
from csv import DictReader, DictWriter
from tempfile import NamedTemporaryFile

def append_csv(csv_filename, data):
	with open(csv_filename, 'a+') as csv_file:
		reader = DictReader(csv_file)
		new_keys = set(data.keys()).difference(reader.fieldnames)
		if not new_keys:
			csv_file.seek(0, os.SEEK_END)
			writer = DictWriter(csv_file, reader.fieldnames)
			writer.writerow(data)
		else:
			reader.fieldnames.extend(sorted(new_keys))
			with NamedTemporaryFile(dir='.', delete=False) as csv_tmpfile:
				writer = DictWriter(csv_tmpfile, reader.fieldnames, lineterminator='\n')
				writer.writeheader()
				writer.writerows(row for row in reader)
				writer.writerow(data)
			shutil.move(csv_tmpfile.name, csv_filename)

def folderWalk(folder_path):
	for filename in glob.glob(os.path.join(folder_path, '*.csv')):
		with open(filename, 'r') as f:
			text = f.read()
			append_csv(filename, text)

def main():
	folder_path = './NER-OUTPUT'
	folderWalk(folder_path)

main()