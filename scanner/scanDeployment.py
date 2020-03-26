#!/usr/bin/env python3

import os, sys
from argparse import ArgumentParser

def main():

	executedWithErrors = 0

	parser = ArgumentParser()
	parser.add_argument("filename", type=str, help="Path to the deployment file to be scanned")
	parser.add_argument("-v", "--verbose", action="store_true", help="Provide more execution logs")

	args = parser.parse_args()

	print("Hello from Python!")

main()