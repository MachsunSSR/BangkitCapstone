from flask import Flask, request, jsonify

app = Flask(__name__)


@app.route('/')
def hello_world():
    return 'This is my first API call!'

@app.route('/post', methods=["POST"])
def testpost():
    input_json = request.get_json(force=True) 
    # Pickle operation here trying
    
    dictToReturn = {
        'data' : [
            {
                'name' : 'Comma Hair',
                'desc' : 'template desc',
                'imageUrl' : 'template image',
                'totalRating' : 'template totalRating',
            },
            {
                'name' : 'Pompador',
                'desc' : 'template desc',
                'imageUrl' : 'template image',
                'totalRating' : 'template totalRating',
            },
            {
                'name' : 'Buzz Cut',
                'desc' : 'template desc',
                'imageUrl' : 'template image',
                'totalRating' : 'template totalRating',
            },
        ],
        'status': 201 
    }
    return jsonify(dictToReturn)